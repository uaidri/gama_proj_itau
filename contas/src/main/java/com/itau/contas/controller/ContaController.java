package com.itau.contas.controller;

import java.util.List;

import com.itau.contas.model.Conta;
import com.itau.contas.repository.ContaRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/contas")
public class ContaController {
    @Autowired // injecao de dependencia
    private ContaRepo repo;

    @GetMapping
    public List<Conta> listarTodos() {
        List<Conta> lista = (List<Conta>) repo.findAll();

        return lista;
    }




    @GetMapping("/{cod}")
    public ResponseEntity<Conta> buscaPorCodigo(@PathVariable int cod ){
        Conta conta = repo.findById(cod).orElse(null);
        if(conta !=null){
            return ResponseEntity.ok(conta); 
        }
        return ResponseEntity.notFound().build();

    }

}
