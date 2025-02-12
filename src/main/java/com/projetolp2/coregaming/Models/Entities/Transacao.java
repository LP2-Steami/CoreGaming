package com.projetolp2.coregaming.Models.Entities;

import java.util.Date;
import java.util.Objects;

public class Transacao {
    private int id_transacao;
    private int id_usuario;
    private int quantidade;
    private Date data_transacao;


    public void setId_transacao(int id_transacao) {
        this.id_transacao = id_transacao;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getData_transacao() {
        return data_transacao;
    }

    public void setData_transacao(Date data_transacao) {
        this.data_transacao = data_transacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return id_transacao == transacao.id_transacao;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_transacao);
    }
}
