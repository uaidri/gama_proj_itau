package com.itau.contas.repository;

import com.itau.contas.model.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepo extends CrudRepository <Cliente, Integer>{

    
}
