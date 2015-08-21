package com.tt.dominio;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SLA {
	private long id;
	private String criticidade;
	private String tempoReacao;
	private String tempoResposta;
	
	
	@Id
	@GeneratedValue
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column
	public String getCriticidade() {
		return criticidade;
	}
	public void setCriticidade(String criticidade) {
		this.criticidade = criticidade;
	}
	
	@Column
	public String getTempoReacao() {
		return tempoReacao;
	}
	public void setTempoReacao(String tempoReacao) {
		this.tempoReacao = tempoReacao;
	}
	
	@Column
	public String getTempoResposta() {
		return tempoResposta;
	}
	public void setTempoResposta(String tempoResposta) {
		this.tempoResposta = tempoResposta;
	}
	
	
}
