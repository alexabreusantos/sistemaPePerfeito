package com.sistema.peperfeito.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sistema.peperfeito.model.Paciente;
import com.sistema.peperfeito.repository.PacienteRepository;


@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	public Paciente atualizar(Long codigo, Paciente paciente) {
		Paciente pacienteSalvo = buscarPacientePeloCodigo(codigo);
		
		pacienteSalvo.getTelefones().clear();
		pacienteSalvo.getTelefones().addAll(paciente.getTelefones());
		pacienteSalvo.getTelefones().forEach(c -> c.setPaciente(pacienteSalvo));
		
		BeanUtils.copyProperties(paciente, pacienteSalvo, "codigo", "telefones");
		return pacienteRepository.save(pacienteSalvo);
	}
	
	private Paciente buscarPacientePeloCodigo(Long codigo) {
		Paciente pacienteSalvo = pacienteRepository.findOne(codigo);
		if (pacienteSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return pacienteSalvo;
	}

	public Paciente salvar(Paciente paciente) {
		paciente.getTelefones().forEach(c -> c.setPaciente(paciente));
		return pacienteRepository.save(paciente);
	}
	
}
