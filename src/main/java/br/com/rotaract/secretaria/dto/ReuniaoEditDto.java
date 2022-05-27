package br.com.rotaract.secretaria.dto;

import java.time.LocalDateTime;

public class ReuniaoEditDto {
		
		private String assunto;
		private String nome;
		private String local;
		private LocalDateTime data;
		
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
		
		public LocalDateTime getDataReuniao() {
			return data;
		}

		public void setDataReuniao(LocalDateTime data) {
			this.data = data;
		}
}
		
	
		
		
	
		

		

	