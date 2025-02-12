package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.DB.ConnectionDB;
import com.projetolp2.coregaming.Models.Entities.Jogo;
import com.projetolp2.coregaming.Util.Alertas;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarrinhoController {
    @FXML
    private Label nomeJogo;
    @FXML
    private Label preco;

    private Jogo jogo;

    @FXML
    private AnchorPane items;

    public void adicionarJogoAoCarrinho(Jogo jogo) {
        Label nomeJogoNovo = new Label(jogo.getTitulo());
        nomeJogoNovo.setLayoutX(30);
        nomeJogoNovo.setLayoutY(items.getChildren().size() * 30 + 20); // Ajusta a posição Y com base no número de elementos existentes

        Label precoNovo = new Label(String.valueOf(jogo.getPreco()));
        precoNovo.setLayoutX(396);
        precoNovo.setLayoutY(items.getChildren().size() * 30 + 20);

        items.getChildren().addAll(nomeJogoNovo, precoNovo); // Adiciona os Labels ao AnchorPane
        Alertas.mostrarAlerta("Adicionado ao carrinho", "", "Adicionado com sucesso", Alert.AlertType.CONFIRMATION);

    }
}
