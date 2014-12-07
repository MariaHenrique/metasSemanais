package models;


public class Metas implements Comparable<Metas> {

	

	private String nome;
	private String descricao;
	private int prioridade;
	private boolean metaAlcancada;
	
	public Metas(String nome, String prioridade, String descricao) {
		this.nome = nome;
		this.prioridade = Integer.parseInt(prioridade);
		this.descricao = descricao;
		this.metaAlcancada = false;

	}

	//Precisa de construtor vazio para o BD
	public Metas() {
		
	}
	

	public String getNome() {	
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {	
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	@Override
	public int compareTo(Metas arg0) {
		if (this.getPrioridade() > arg0.getPrioridade()){
			return 1;
		}
		else if (this.getPrioridade() < arg0.getPrioridade()) {
			return -1;
		}
		return 0;
	}
	
	public void marcarMeta(){
		if(this.metaAlcancada){
			this.metaAlcancada =  false;
		} else {
			this.metaAlcancada =  true;
		}		
	}

	public boolean ehMetaAlcancada(){
		return this.metaAlcancada;
	}
	
}