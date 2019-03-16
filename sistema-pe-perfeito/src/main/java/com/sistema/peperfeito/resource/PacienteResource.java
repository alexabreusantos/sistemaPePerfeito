package com.sistema.peperfeito.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.peperfeito.event.RecursoCriadoEvent;
import com.sistema.peperfeito.model.Paciente;
import com.sistema.peperfeito.repository.PacienteRepository;
import com.sistema.peperfeito.repository.filter.PacienteFilter;
import com.sistema.peperfeito.repository.projection.ResumoPaciente;
import com.sistema.peperfeito.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteResource {

	@Autowired
	private PacienteRepository pacienteRepository;
	
	@Autowired
	private PacienteService pacienteService;
	
	@Autowired
	private ApplicationEventPublisher publisher;

//	@GetMapping
//	public Page<Paciente> pesquisar(PacienteFilter pacienteFilter, Pageable pageable){
//		return pacienteRepository.filtrar(pacienteFilter, pageable);
//	}
	
	@GetMapping
	public Page<ResumoPaciente> resumir(PacienteFilter pacienteFilter, Pageable pageable){
		return pacienteRepository.resumir(pacienteFilter, pageable);
	}
		
	@PostMapping
	public ResponseEntity<Paciente> criar(@Valid @RequestBody Paciente paciente, HttpServletResponse response) {
		Paciente pacienteSalvo = pacienteService.salvar(paciente);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, pacienteSalvo.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(pacienteSalvo);
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Paciente> buscarPeloCodigo(@PathVariable Long codigo) {
		Paciente paciente = pacienteRepository.findOne(codigo);
		return paciente != null ? ResponseEntity.ok(paciente) : ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		pacienteRepository.delete(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<Paciente> atualizar(@PathVariable Long codigo, @Valid @RequestBody Paciente paciente) {
		Paciente pacienteSalvo = pacienteService.atualizar(codigo, paciente);
		return ResponseEntity.ok(pacienteSalvo);
	}
}
