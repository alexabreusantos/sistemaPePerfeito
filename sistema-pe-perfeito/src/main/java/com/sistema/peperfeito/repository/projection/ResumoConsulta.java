package com.sistema.peperfeito.repository.projection;

import java.time.LocalDateTime;

import com.sistema.peperfeito.model.SituacaoConsulta;

public class ResumoConsulta {
	
	private LocalDateTime dataHora;
	private String paciente;
	private SituacaoConsulta situacao;
	private Double valor;
	private String observacao;
		
	public ResumoConsulta(LocalDateTime dataHora, String paciente, SituacaoConsulta situacao, Double valor, String observacao) {
		super();
		this.dataHora = dataHora;
		this.paciente = paciente;
		this.situacao = situacao;
		this.valor = valor;
		this.observacao = observacao;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public String getPaciente() {
		return paciente;
	}
	public void setPaciente(String paciente) {
		this.paciente = paciente;
	}
	public SituacaoConsulta getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoConsulta situacao) {
		this.situacao = situacao;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
}
