package com.sipagbackend.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sipagbackend.model.Commerce;
import com.sipagbackend.repository.CommerceRepository;
import com.sipagbackend.service.CommerceService;


@RestController
@RequestMapping("/commerce")
public class CommerceResource {

	@Autowired
	private CommerceRepository repository;
	
	@Autowired
	private CommerceService commerceService;

	@GetMapping
	public List<Commerce> listar() {
		return repository.findAll();

	}

	@PostMapping
	public ResponseEntity<Commerce> criar(@Valid @RequestBody Commerce commerce, HttpServletResponse response) {
		Commerce commerceSalva = repository.save(commerce);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idCommerce}")
				.buildAndExpand(commerceSalva.getIdCommerce()).toUri();

		response.setHeader("Location", uri.toASCIIString());

		return ResponseEntity.created(uri).body(commerceSalva);
	}

/*	@GetMapping("/{idCommerce}")
    public ResponseEntity<Commerce> buscarPeloCodigo(@PathVariable Long idCommerce) {
	    Optional<Commerce> commerce = this.repository.findById(idCommerce);
	    return commerce.isPresent() ? 
	            ResponseEntity.ok(commerce.get()) : ResponseEntity.notFound().build();
	}*/
	
	@GetMapping("/{idCommerce}")
	 public ResponseEntity<Optional<Commerce>> buscarPeloCodigo(@PathVariable Long idCommerce) {
		 Optional<Commerce> commerce = repository.findById(idCommerce);
		 if (commerce != null)
			return ResponseEntity.ok(commerce);
		else
			return ResponseEntity.notFound().build();	
	 }
	
	@DeleteMapping("/{idCommerce}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletCommerce(@PathVariable Long idCommerce) {
	  	repository.deleteById(idCommerce);
	  	
	}
	
	@PutMapping("/{idCommerce}")
	public ResponseEntity<Commerce> atualizar(@PathVariable Long idCommerce, @Valid @RequestBody Commerce commerce) {
	 Commerce commerceSalva = commerceService.atualizar(idCommerce, commerce);
	  return  ResponseEntity.ok(commerceSalva);
	}
	
}
