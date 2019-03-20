package com.sistema.peperfeito.repository.filter;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

public class ConsultaFilter {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime dataHora;
	
	private String paciente;
	
	private String situacao;

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

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}	
}
