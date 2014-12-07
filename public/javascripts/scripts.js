$(function(){
	deletarMeta();	
	marcarMeta();
	marcaCheckbox();
});

function deletarMeta(){
	$(".deletar").click(function(){
		var nomeMeta = $(this).attr("id");
		
		$.ajax({
		    url: "/deletarMeta/"+nomeMeta,
		    type: "DELETE"
		}).done(function(){
		    window.location.href = "/";
		});
	});
}

function marcaCheckbox(){
	$(".true").each(function(){
		$(this).find(":checkbox").attr("checked", "true");
	});
}

function marcarMeta(){
	$("table > tbody > tr > td > :checkbox").click(function(){	
	
		var nomeMeta = $(this).attr("value");	
		var tr = $(this).parent().parent();
				
		if($(this).is(':checked')){			
			
			$(tr).addClass("metaAlcancada");
			
			
		} else {
			$(tr).removeClass("metaAlcancada");
		}
		
		$.ajax({
			    url: "/marcarMeta/"+nomeMeta,
			    type: "POST"
			}).done(function(){
			    window.location.href = "/";
			});
	});
}