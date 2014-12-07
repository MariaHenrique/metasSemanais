package models;


import java.util.*;

public class Semana {
		
		private List<Metas> metas;
		private String nome;
		
	
		public Semana() {	
			metas = new ArrayList<Metas>();
		}
		
		public boolean isEmpty() {
			if (metas.isEmpty()) {
				return true;
			}
			return false;
		}
		
		//Permite adicionar uma nova meta
		public void adicionarMeta(Metas meta) {
			metas.add(meta);
			Collections.sort(this.getMetas());
		}
		
		public List<Metas> getMetas() {
			return metas;
		}
		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public int quantMetas(){
			return metas.size();
		}
		
		
		public int quantMetasAlcancadas(){
			int count = 0;
			for(int i = 0; i < quantMetas(); i++){
				if(metas.get(i).ehMetaAlcancada()){
					count ++;
				}
			}
			return count;
		}
		
		public int quantMetasDesejadas(){
			return quantMetas() - quantMetasAlcancadas();
		}
		
	
		
	}
