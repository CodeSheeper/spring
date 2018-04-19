$(function(){
	$("#showdata tr:even").css("background-color","#FF00FF");
	$("#showdata tr:odd").css("background-color","#00FF00");
	$("#showdata tr:eq(0)").css("background-color","#0000FF");
	
	
	$("#showdata tr").click(function(){
		 var id=$(this).children().html();
		 var name=$(this).children(".name").html();
		 var age=$(this).children(".age").html();
			$("#updateform[name=id]").val(id);
			$("#updateform[name=name]").val(name);
			$("#updateform[age=age]").val(age);
	})
});