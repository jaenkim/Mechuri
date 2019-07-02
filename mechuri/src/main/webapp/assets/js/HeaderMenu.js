/**
 * 
 */
$(function() {
	$("#accordian p").click(function() {
		$("#accordian ul ul").slideUp();
		if (!$(this).next().is(":visible")) {
			$(this).next().slideDown();
		}
	})
})