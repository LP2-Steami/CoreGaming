package com.projetolp2.coregaming.Models.Entities;

import javafx.scene.image.Image;

import java.time.LocalDate;
import java.util.Objects;


public class Usuario{


    private static int id;

    private String nome;

    private String email;

    private String senha;

    private LocalDate dataCriacao;

    private Image foto;


    // Construtores

    public Usuario() {
    }

    //Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    // Getters e Setters
    public int getId() { return id; }
    public static void setId(int id) {Usuario.id = id;}

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }
    public void setDataCriacao(LocalDate dataCriacao) { this.dataCriacao = dataCriacao; }

//    public Image getFoto() {
//        return foto;
//    }
//    public void setFoto(Image foto) {
//        this.foto = foto;
//    }
}
