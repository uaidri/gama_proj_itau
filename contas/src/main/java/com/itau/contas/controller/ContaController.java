package com.itau.contas.controller;

import java.util.List;

import com.itau.contas.model.Conta;
import com.itau.contas.repository.ContaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/contas")
public class ContaController {
    @Autowired // injecao de dependencia
    private ContaRepo repo;

    public List<Conta> MostrarContas() {
        List<Conta> lista = (List<Conta>) repo.findAll();

        return lista;

    }

}
