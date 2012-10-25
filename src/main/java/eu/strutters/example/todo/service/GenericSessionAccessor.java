package eu.strutters.example.todo.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.inject.Inject;

/**
 * GenericSessionAccessor.
 *
 * @author Rene Gielen
 */
public class GenericSessionAccessor {

	@Inject
	SessionFactory sessionFactory;

	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void clear() {
		getCurrentSession().clear();
	}
}
