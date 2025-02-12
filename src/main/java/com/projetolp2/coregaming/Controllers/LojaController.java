package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.AplicacaoBase;
import com.projetolp2.coregaming.DB.ConnectionDB;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;
import java.util.ResourceBundle;

public class LojaController {

    @FXML
    private ImageView imageView;

    public void mostrarJogo() throws IOException {
        Connection connection = null;
        PreparedStatement psJogo = null;
        ResultSet rs = null;

        try {
            connection = ConnectionDB.getConnection();
            psJogo = connection.prepareStatement("SELECT * FROM jogo WHERE foto = ?");
            psJogo.setString(1, "foto");
            rs = psJogo.executeQuery();


        } catch (SQLException e) {
                throw new RuntimeException(e);
        }
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
        AplicacaoBase.novaTela("perfil.fxml", "Perfil do Usuário");
    }
    @FXML
    public void onAtualizarPerfilButtonClicked() throws IOException {
        AplicacaoBase.novaTela("atualizar-perfil.fxml", "Atualizar Perfil");
    }
    @FXML
    public void onCarrinhoButtonClicked() throws IOException {
        AplicacaoBase.newStage("carrinho.fxml", "Carrinho");
    }
    @FXML
    public void onDeletarPerfilClicked() throws IOException {
            AplicacaoBase.novaTela("confirmar-deletar.fxml", "Deletar perfil");
    }
    @FXML
    public void onSairButtonClicked() throws IOException {
        AplicacaoBase.newStage("login.fxml", "Logar perfil");
    }
}
