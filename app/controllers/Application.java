package controllers;

import play.mvc.*;
import play.data.Form;
import play.data.DynamicForm;
import views.html.*;

import java.util.List;

import models.Metas;
import models.MetasDaSemana;
import models.Semana;

public class Application extends Controller {


	private static MetasDaSemana metasdasemana = new MetasDaSemana();
	private static List<Semana> semanas = metasdasemana.getSemanas();

	public static Result index() {
		return ok(index.render(semanas, null));
	}


	public static Result adicionarMeta() {
		DynamicForm form = Form.form().bindFromRequest();
		Metas meta;

		String nome = form.get("nome");
		String prioridade = form.get("prioridade");
		String descricao = form.get("descricao");
		String semana = form.get("semana");


		metasdasemana.novaMeta(new Metas(nome, prioridade, descricao), semana);
		
		return index();
	}
	
	public static Result deletarMeta(String id) {
		String nome = id;
		for (int i = 0; i < MetasDaSemana.getSemanas().size(); i++) {
			for (int j = 0; j < MetasDaSemana.getSemanas().get(i).quantMetas(); j++) {
				if(MetasDaSemana.getSemanas().get(i).getMetas().get(j).getNome().equals(nome)){
					MetasDaSemana.getSemanas().get(i).getMetas().remove(MetasDaSemana.getSemanas().get(i).getMetas().get(j));
				}
			}
		}
		return index();
	}
	
	public static Result marcarMetaAlcancada(String nomeMeta){    	
    	for(int i = 0; i < MetasDaSemana.getSemanas().size(); i++){
    		for(int j = 0; j < MetasDaSemana.getSemanas().get(i).quantMetas(); j++ ){
    			if(nomeMeta.equals(MetasDaSemana.getSemanas().get(i).getMetas().get(j).getNome())){
    				MetasDaSemana.getSemanas().get(i).getMetas().get(j).marcarMeta();				
    			}
    		}    		
    	}
    	return index();
    }

}