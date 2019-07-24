/**
 * 
 */

$(function(){
	$('.starRev > span').mouseenter(function(){
		  $(this).parent().children('span').removeClass('on');
		  $(this).addClass('on').prevAll('span').addClass('on');
		  return false;
		});
	$(".starR1,.starR2").mouseover(function(){
		$("input[name=review_rating]").val(($(".on").length)/2); 		
	});
	
});


$(function(){
	var rate=$(".starRev").find("input[name=rate]").val();
//		alert(parseFloat(rate));
	var k=0;
	for(var i=0;i<parseFloat(rate);i+=0.5){
	  $(".starRev>span").eq(k).addClass('on');
		k++;
	}
	
	
//		  $(this).parent().children('span').removeClass('on');
});