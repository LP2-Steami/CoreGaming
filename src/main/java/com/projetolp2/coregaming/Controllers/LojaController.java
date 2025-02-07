package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.AplicacaoBase;
import com.projetolp2.coregaming.Models.Entities.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class LojaController {

    private Usuario usuario;

    @FXML
    public void onLojaButtonClicked() throws IOException {
        AplicacaoBase.newStage("loja.fxml", "Loja");
    }
    @FXML
    public void onBibliotecaButtonClicked() throws IOException {
        AplicacaoBase.newStage("biblioteca.fxml", "Biblioteca");
    }
    @FXML
    public void onVerPerfilButtonClicked() throws IOException {
        AplicacaoBase.newStage("perfil.fxml", "Perfil do Usuário");
    }
    @FXML
    public void onAtualizarPerfilButtonClicked() throws IOException {
        AplicacaoBase.newStage("atualizar-perfil.fxml", "Atualizar Perfil");
    }
    @FXML
    public void onCarrinhoButtonClicked() throws IOException {
        AplicacaoBase.newStage("carrinho.fxml", "Carrinho");
    }
    @FXML
    public void onSairButtonClicked() throws IOException {
        AplicacaoBase.newStage("login.fxml", "Logar perfil");

    }
}