package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.AplicacaoBase;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class LojaController {
    public MenuItem atualizarPerfil;
    @FXML
    private MenuBar menuBarLoja;
    @FXML
    private Menu loja;
    @FXML
    private Menu biblioteca;
    @FXML
    private Menu usuario;
    @FXML
    private Menu carrinho;
    @FXML
    private MenuItem criarPerfil;
    @FXML
    private MenuItem verPerfil;
    @FXML
    private MenuItem alterarPerfil;
    @FXML
    private MenuItem sairPerfil;
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private ImageView img1;
    @FXML
    private ImageView img2;
    @FXML
    private ImageView img3;
    @FXML
    private ImageView img4;

    static Stage stage;

    public static Stage getStage() {
        return stage;
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