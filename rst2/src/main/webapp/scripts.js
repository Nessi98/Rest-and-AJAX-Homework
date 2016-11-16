$(document).ready(function() {
	$.get({
		url: "http://localhost:8080/rest/api/automobiles",
		contentType: "application/json",
		success: function(data){
			console.log(data);
			$.each(data, function(index){
						var tr = $('<tr>');
						tr.append("<td> " + data[index].brand + "</td>");
						tr.append("<td> " + data[index].model + "</td>");
						tr.append("<td> " + data[index].engineType + "</td>");
						tr.append("<td> " + data[index].color + "</td>");
						$("#automobilesTable").append(tr);
					});
				}
	
			});
$("#button").click(function(){
	$.post({
		url: "http://localhost:8080/rest/api/automobiles",
		contentType: "application/json",
		data:{
			brand: $("#newBrand").val(),
			model: $("#newModel").val(),
			engineType: $("#newEngineType").val(),
			color: $("#newColor").val()
		}
	});
});
});