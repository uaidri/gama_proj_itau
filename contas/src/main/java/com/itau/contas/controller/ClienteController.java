package com.itau.contas.controller;

import java.util.List;

import com.itau.contas.model.Cliente;
import com.itau.contas.repository.ClienteRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired // injecao de dependencia
    private ClienteRepo repo;

    @GetMapping
    public List<Cliente> listarTodos() {
        List<Cliente> lista = (List<Cliente>) repo.findAll();

        return lista;
    }
    @GetMapping("/{cod}")
    public ResponseEntity<Cliente> buscaPorCodigo(@PathVariable int cod ){
        Cliente cliente = repo.findById(cod).orElse(null);
        if(cliente !=null){
            return ResponseEntity.ok(cliente); 
        }
        return ResponseEntity.notFound().build();

    }
    
}
