package com.itau.contas.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity // indica que esta classe sera armazenada no Banco de dados
@Table(name = "tb_contas")
public class Conta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 1,2, 3,...
    private int codigo;
    @Column(name = "numero", nullable = false)
    private int numero;
    @Column(name = "agencia", nullable = false)
    private int agencia;
    @Column(name = "tipo_conta", nullable = false)
    private TipoConta tipo;
    @Column(name = "saldo")
    private Double saldo;
    
    @ManyToOne
    @JoinColumn(name = "titular_conta")
    @JsonIgnoreProperties("contas")
    private Cliente titularConta;

    public Conta(){
        
    }

    public Conta(int numero, int agencia, TipoConta tipo, Cliente  titularConta) {
        this.numero = numero;
        this.agencia = agencia;
        this.tipo = tipo;
        this.saldo = 0.0;
        this.titularConta = titularConta;

    }

    public int getNumero() {
        return numero;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConta tipo) {
        this.tipo = tipo;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Cliente getTitularConta() {
        return titularConta;
    }

    public void setTitularConta(Cliente titularConta) {
        this.titularConta = titularConta;
    }

}
