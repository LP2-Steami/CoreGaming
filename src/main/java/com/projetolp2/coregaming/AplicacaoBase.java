package com.projetolp2.coregaming;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;


public class AplicacaoBase extends Application {
    public static Scene scene;
    public static Stage stageAtual;
    public static Image image = new Image("https://img.icons8.com/?size=100&id=uo64lU1nVLPh&format=png&color=000000");

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AplicacaoBase.class.getResource("login.fxml"));
        scene = new Scene(fxmlLoader.load());
        stageAtual = stage;
        stage.setTitle("CoreGaming");
        stage.setResizable(false);
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }

    public static void newStage(String fxml, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(AplicacaoBase.class.getResource(fxml));
        scene = new Scene(loader.load());
        Stage novoStage = new Stage();
        novoStage.setTitle(title);
        novoStage.setResizable(false);
        novoStage.getIcons().add(image);
        novoStage.setScene(scene);
        novoStage.show();
        stageAtual.close();
        stageAtual = novoStage;
    }

    public static Scene getScene(){
        return scene;
    }

    public static Stage getStage() {
        return stageAtual;
    }

    public static void main(String[] args) {
        launch();
    }
}