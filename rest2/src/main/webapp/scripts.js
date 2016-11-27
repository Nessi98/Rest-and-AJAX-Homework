var current_page = 0;
$(document).ready(function() {
	$.get({
		url: "http://localhost:8080/rest/api/automobiles",
		contentType: "application/json",
		data:{
			page : current_page,
			perPage : 100
		},
		success: function(res){
			//console.log(res.data);
			$.each(res.data, function(index){
						var tr = $('<tr>');
						tr.append("<td> " + res.data[index].brand + "</td>");
						tr.append("<td> " + res.data[index].model + "</td>");
						tr.append("<td> " + res.data[index].engineType + "</td>");
						tr.append("<td> " + res.data[index].color + "</td>");
						$("#automobilesTable").append(tr);
					});
				}
	
			});
$("#button").click(function(){
	$.post({
		url: "http://localhost:8080/rest/api/automobiles",
		contentType: "application/json",
		data:JSON.stringify({
			brand: $("#newBrand").val(),
			model: $("#newModel").val(),
			engineType: $("#newEngineType").val(),
			color: $("#newColor").val()
		})
	});
});
});
