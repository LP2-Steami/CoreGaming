package com.projetolp2.coregaming;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AplicacaoBase extends Application {
    public Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(AplicacaoBase.class.getResource("loja.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("CoreGaming");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e-> Platform.exit());
    }

    public static void newStage(String fxml, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(AplicacaoBase.class.getResource(fxml));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}