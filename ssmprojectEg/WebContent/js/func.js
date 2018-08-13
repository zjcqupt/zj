/**
 * 
 */
$(function(){
$(".delete").click(function(){
	var href=$(this).attr("href");
	$("form").attr("action",href).submit();
	   alert('交易完成');  
	return false ;
});

$("#cnm").click(function(){
	alert("cnm");
	});

$("#next").click(function(){

});

})
