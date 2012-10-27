$(document).ready(function() {
	$(".collapse").collapse();

	$.subscribe('/todo/status', function(event, data) {
		var item = event.originalEvent.data.item;
		if(item && item.done === true) {
		  $('#todoTopic'+item.id).addClass("todo-done");
		  $('#todoDoneLink'+item.id).remove();
		}
	});
	$.subscribe('/todo/remove', function(event, data) {
		var item = event.originalEvent.data.item;
		$('#todoItem'+item.id).hide("clip", {}, 1000, function(){
			$(this).remove();
		});
	});
});