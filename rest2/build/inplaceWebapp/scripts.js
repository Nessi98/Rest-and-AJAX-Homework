var current_page = 0;
var busy = false;
var done = false;
var filterBrand = "";
var filterModel = "";
var filterEngineType = "";
var filterColor = "";

function getData(){
	if(!busy && !done){
		console.log(busy);
		busy = true;
		var data = {};
		if(filterBrand != ""){
			data.brand = filterBrand;
		}
			
		if(filterModel != ""){
			data.model = filterModel;
		}
		
		if(filterEngineType != ""){
			data.engineType = filterEngineType;
		}
		
		if(filterColor != ""){
			data.color = filterColor;
		}
		data.page = current_page;
		data.perPage = 12;
		$.get({
			url: "http://localhost:8080/rest/api/automobiles",
			contentType: "application/json",
			data: data,
			success: function(res){
				if(res.data.length == 0){
					done = true;
				}
				$.each(res.data, function(index){
					var tr = $('<tr>');
					tr.append("<td> " + res.data[index].brand + "</td>");
					tr.append("<td> " + res.data[index].model + "</td>");
					tr.append("<td> " + res.data[index].engineType + "</td>");
					tr.append("<td> " + res.data[index].color + "</td>");
					$("#automobilesTable").append(tr);
				});
				current_page ++;
				$(window).scroll();
			}
			
		});
		busy = false;
	}
}

$(document).ready(function() {

	$("#addAutomobile").click(function(){
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
	
	$("#filter").submit(function(e){
		e.preventDefault();
		filterBrand = $("#filterBrand").val();
		filterModel = $("#filterModel").val();
		filterEngineType = $("#filterEngineType").val();
		filterColor = $("#filterColor").val();
		
		 var tr = $("tr");
		 for (i = 0; i < tr.length; i++) {
			 td = tr[i].getElementsByTagName("td")[0];
			 if(td){
				 if(td.innerHTML.toUpperCase().indexOf(filter) > -1) {
					 tr[i].style.display = "";
				 }else{
					 tr[i].style.display = "none";
				 }
			 }
		 }
		//$("#automobilesTable").empty();
		current_page = 0;
		done = false;
		getData();
	});
	
	$(window).on('scroll', function(){
	    if($(window).scrollTop() >= $(document).height() - $(window).height()) {
	    	getData();
	    }
	}).scroll();
});
