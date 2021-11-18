package com.itau.contas.repository;

import com.itau.contas.model.Conta;

import org.springframework.data.repository.CrudRepository;

public interface ContaRepo extends CrudRepository <Conta, Integer> {
    
}
