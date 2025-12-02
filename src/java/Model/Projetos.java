/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author alunocmc
 */
public class Projetos {
    private int id;
    private String nome;
    private String descricao;
    private String cliente;
    private Date datainicio;
    private Date datafimprevista;
    private String responsavel;
    private String status;
    private double orcamento;
    private String prioridade;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCliente() {
        return cliente;
    }

    public Date getDatainicio() {
        return datainicio;
    }

    public Date getDatafimprevista() {
        return datafimprevista;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public String getStatus() {
        return status;
    }

    public double getOrcamento() {
        return orcamento;
    }

    public String getPrioridade() {
        return prioridade;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void setDatainicio(Date datainicio) {
        this.datainicio = datainicio;
    }

    public void setDatafimprevista(Date datafimprevista) {
        this.datafimprevista = datafimprevista;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrcamento(double orcamento) {
        this.orcamento = orcamento;
    }

    public void setPrioridade(String prioridade) {
        this.prioridade = prioridade;
    }

   
    
    
}
