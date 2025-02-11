package com.projetolp2.coregaming.Models.Entities;

import java.util.Date;
import java.util.Objects;

public class Jogo {
    private int id_jogo;
    private int id_desenvolvedor;
    private String titulo;
    private String descricao;
    private float preco;
    private Date dataLancamento;
    private byte[] foto;

    public Jogo() {
    }

    public int getId_jogo() {return id_jogo;}
    public void setId_jogo(int id_jogo) {this.id_jogo = id_jogo;}

    public int getId_desenvolvedor() {return id_desenvolvedor;}
    public void setId_desenvolvedor(int id_desenvolvedor) {this.id_desenvolvedor = id_desenvolvedor;}

    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}

    public String getDescricao() {return descricao;}
    public void setDescricao(String descricao) {this.descricao = descricao;}

    public float getPreco() {return preco;}
    public void setPreco(float preco) {this.preco = preco;}

    public Date getDataLancamento() {return dataLancamento;}
    public void setDataLancamento(Date dataLancamento) {this.dataLancamento = dataLancamento;}

    public byte[] getFoto() {return foto;}
    public void setFoto(byte[] foto) {this.foto = foto;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Jogo jogo = (Jogo) o;
        return id_jogo == jogo.id_jogo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id_jogo);
    }
}
