package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.AplicacaoBase;
import com.projetolp2.coregaming.Models.Entities.Jogo;
import com.projetolp2.coregaming.Models.Entities.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class BibliotecaController {
    public MenuItem verPerfil;
    public MenuItem atualizarPerfil;
    public ImageView fotoJogo;
    public TextArea descricaoJogo;
    public Button botaoJogar;
    public Label tituloJogo;
    @FXML
    private Label tituloJogoSideBar;
    private Jogo jogo;
    private Usuario usuarioAtual;

    public void mostrarJogos() {
        tituloJogoSideBar.setText(jogo.getTitulo());
    }

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
}
