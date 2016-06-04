package eu.strutters.example.todo.interceptor;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.inject.Inject;

/**
 * TransactionalInterceptor.
 *
 * @author Rene Gielen
 */
public class TransactionalInterceptor extends MethodFilterInterceptor {

	private static final Logger log = LogManager.getLogger(TransactionalInterceptor.class);

	@Inject
	private PlatformTransactionManager transactionManager;

	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		if (transactionManager != null) {

			TransactionStatus txStatus = createTransactionContext();

			try {
				// Invoke Action
				String result = actionInvocation.invoke();

				// INPUT and ERROR result will lead to rollback
				markForRollbackOnErrorOrInput(txStatus, result);

				endTransaction(txStatus);
				return result;

			} catch (Exception e) {
				return rollbackAndThrow(txStatus, e);


			}
		} else {

			// Transaction manager was not configured, proceed without transaction context
			return actionInvocation.invoke();
		}
	}

	private void markForRollbackOnErrorOrInput( TransactionStatus status, String result ) {
		if (Action.INPUT.equals(result) || Action.ERROR.equals(result)) {
			// Special treatment of INPUT/ERROR result, forcing rollback
			status.setRollbackOnly();
			log.info("[doIntercept]: Setting current transaction to rollbackOnly due to INPUT action invocation result");
		}
	}

	private void endTransaction(TransactionStatus status) {
		if (!status.isCompleted()) {
			// Life's good, lets's commit
			transactionManager.commit(status);
			log.debug("[doIntercept]: Transaction ended regularly.");
		} else {
			// for some reason, the transaction was already completed
			log.warn("[doIntercept]: Transaction already marked as completed, not performing commit");
		}
	}

	private TransactionStatus createTransactionContext() {
		TransactionStatus status;
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setName("TransactionalInterceptor@" + def.hashCode());
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

		// Create Transaction Context
		status = transactionManager.getTransaction(def);
		log.debug("[doIntercept]: Transaction context created.");
		return status;
	}

	private String rollbackAndThrow(TransactionStatus status, Exception e) throws Exception {
		// Bad things happened - an Exception popping up here is should force a rollback
		if (!status.isCompleted()) {
			transactionManager.rollback(status);
			log.warn("[doIntercept]: Rolled back due to uncatched exception: " + e.getMessage());
		} else {
			// for some reason, the transaction was already completed
			log.warn("[doIntercept]: Transaction already marked as completed, not performing rollback indicated by uncatched Excption " + e.getMessage());
		}
		// Finally, we'll be nicely rethrowing the exception
		throw e;
	}

}