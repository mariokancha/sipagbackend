package com.sipagbackend.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.sipagbackend.model.Commerce;
import com.sipagbackend.repository.CommerceRepository;

@Service
public class CommerceService {

	@Autowired
	private CommerceRepository repository;

	public Commerce atualizar(Long idCommerce, Commerce commerce) {

		Commerce commerceSalva = this.repository.findById(idCommerce)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		if (commerceSalva == null) {
			throw new EmptyResultDataAccessException(1);
		} else
	    BeanUtils.copyProperties(commerce, commerceSalva, "idCommerce");
		return this.repository.save(commerceSalva);
	}
}
