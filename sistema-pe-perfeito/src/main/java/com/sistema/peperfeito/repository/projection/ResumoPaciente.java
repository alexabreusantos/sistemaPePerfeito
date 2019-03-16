package com.sistema.peperfeito.repository.projection;

import java.time.LocalDate;

public class ResumoPaciente {
	private Long codigo;
	private String nome;
	private LocalDate dataNascimento;
	private String email;
	
	public ResumoPaciente(Long codigo, String nome, LocalDate dataNascimento, String email) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
