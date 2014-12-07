package models;

import java.util.ArrayList;
import java.util.List;


public class MetasDaSemana {

	
	private static List<Semana> semanas;

	public MetasDaSemana() {
		semanas = new ArrayList<Semana>();
		for (int i = 0; i < 6; i++) {
			semanas.add(new Semana());
			semanas.get(i).setNome("Semana" + i);
		}
	}

	public static List<Semana> getSemanas() {
		return semanas;
	}
	
	public static  void setSemana(Semana semana) {
		semanas.add(semana);
	}
	
	public void novaMeta(Metas meta, String semana){
	
	switch (semana) {
	case "1":
		semanas.get(0).adicionarMeta(meta);
		break;
	case "2":
		semanas.get(1).adicionarMeta(meta);
		break;
	case "3":
		semanas.get(2).adicionarMeta(meta);
		break;
	case "4":
		semanas.get(3).adicionarMeta(meta);
		break;
	case "5":
		semanas.get(4).adicionarMeta(meta);
		break;
	case "6":
		semanas.get(5).adicionarMeta(meta);
		break;
	default:
		break;
	}
	
}
}
