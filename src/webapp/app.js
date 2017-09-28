$("button").click(function(){
	alert("Hello world")
    $.getJSON("http://localhost:8080/employees/", function(result){
        $.each(result, function(i, field){
            $("div").append(field + " ");
        });
    });
});
