package br.com.rotaract.secretaria.dto;

import java.time.LocalDate;

public class ReuniaoEditDto {
		
		private String assunto;
		private String nome;
		private String local;
		private LocalDate data;
		
		public String getAssunto() {
			return assunto;
		}

		public void setAssunto(String assunto) {
			this.assunto = assunto;
		}
		
		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getLocal() {
			return local;
		}

		public void setLocal(String local) {
			this.local = local;
		}
		
		public LocalDate getDataReuniao() {
			return data;
		}

		public void setDataReuniao(LocalDate data) {
			this.data = data;
		}
}
		
	
		
		
	
		

		

	