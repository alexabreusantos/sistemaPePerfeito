package com.sistema.peperfeito.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.sistema.peperfeito.model.Consulta;
import com.sistema.peperfeito.repository.ConsultaRepository;
import com.sistema.peperfeito.repository.filter.ConsultaFilter;
import com.sistema.peperfeito.repository.projection.ResumoConsulta;
import com.sistema.peperfeito.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaResource {

	@Autowired
	private ConsultaRepository consultaRepository;
	
	@Autowired
	private ConsultaService consultaService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
//	@GetMapping
//	public Page<ResumoConsulta> pesquisar(ConsultaFilter consultaFilter, Pageable pageable){
//		return consultaRepository.filtrar(consultaFilter, pageable);
//	}
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CONSULTA') and #oauth2.hasScope('read')")
	public Page<ResumoConsulta> resumir(ConsultaFilter consultaFilter, Pageable pageable){
		return consultaRepository.resumir(consultaFilter, pageable);
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CONSULTA') and #oauth2.hasScope('write')")
	public ResponseEntity<Consulta> criar(@Valid @RequestBody Consulta consulta, HttpServletResponse response) {
		Consulta consultaSalva = consultaService.salvar(consulta);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, consultaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(consultaSalva);
	}	

	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_CONSULTA') and #oauth2.hasScope('read')")
	public ResponseEntity<Consulta> buscarPeloCodigo(@PathVariable Long codigo) {
		Consulta consulta = consultaRepository.findOne(codigo);
		return consulta != null ? ResponseEntity.ok(consulta) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_CONSULTA') and #oauth2.hasScope('write')")
	public ResponseEntity<Consulta> atualizar(@PathVariable Long codigo, @Valid @RequestBody Consulta consulta) {
		Consulta consultaSalva = consultaService.atualizar(codigo, consulta);
		return ResponseEntity.ok(consultaSalva);
	}	

	@DeleteMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_REMOVER_CONSULTA') and #oauth2.hasScope('write')")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		consultaRepository.delete(codigo);
	}
}
