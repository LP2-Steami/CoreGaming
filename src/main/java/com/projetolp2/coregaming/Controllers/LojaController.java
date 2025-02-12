package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.AplicacaoBase;
import javafx.fxml.FXML;
import java.io.IOException;

public class LojaController {

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
    public void onSairButtonClicked() throws IOException {
        AplicacaoBase.newStage("login.fxml", "Logar perfil");
    }
}

//    private VBox criarGameBox(String nome, String preco, String url) {
//        VBox vbox = new VBox(10);
//        vbox.setStyle("-fx-background-color: #1E1E1E; -fx-padding: 10px; -fx-border-radius: 5px;");
//
//        ImageView imageView = new ImageView(new Image(url));
//        imageView.setFitHeight(250);
//        imageView.setFitWidth(200);
//        imageView.setPreserveRatio(true);
//
//        Text title = new Text(nome);
//        title.setStyle("-fx-fill: white; -fx-font-size: 16px;");
//
//        Text price = new Text(preco);
//        price.setStyle("-fx-fill: #00FF00; -fx-font-size: 14px;");
//
//        Button buyButton = new Button("Comprar");
//        buyButton.setStyle("-fx-background-color: #0078D7; -fx-text-fill: white;");
//
//        vbox.getChildren().addAll(imageView, title, price, buyButton);
//        return vbox;
//    }