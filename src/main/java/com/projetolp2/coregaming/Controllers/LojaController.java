package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.AplicacaoBase;
import com.projetolp2.coregaming.DB.ConnectionDB;
import com.projetolp2.coregaming.Models.Entities.Jogo;
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
import java.nio.file.Path;
import java.nio.file.Paths;

public class LojaController {

    @FXML
    private ImageView AC2;


    public void mostrarJogo() throws IOException {
        Connection connection = null;
        PreparedStatement psJogo = null;
        ResultSet rs = null;
        String sku = null;

        try {
            connection = ConnectionDB.getConnection();
            psJogo = connection.prepareStatement("SELECT * FROM jogo WHERE sku = ?");
            psJogo.setString(1, AC2.getId());
            rs = psJogo.executeQuery();

            if (rs.next()) {
                System.out.println("informacao do jogo: " + rs.getString("sku"));
                Jogo jogo = new Jogo();
                jogo.setTitulo(rs.getString("titulo"));
                jogo.setDescricao(rs.getString("descricao"));
                jogo.setPreco(rs.getFloat("preco"));
                jogo.setDataLancamento(rs.getDate("data_lancamento"));
                AplicacaoBase.novaTelaJogo("telaJogo.fxml", "Informações do jogo: " + rs.getString("titulo"), jogo);
            }

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
