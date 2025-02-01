package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.AplicacaoBase;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.File;


public class PerfilController {
    @FXML
    private ImageView imgUsuario;
    @FXML
    private Label nomeUsuario;
    @FXML
    private TextField nomeUsuarioField;
    @FXML
    private Label emailUsuario;
    @FXML
    private TextField emailUsuarioField;
    @FXML
    private Label senhaUsuario;
    @FXML
    private TextField senhaUsuarioField;
    @FXML
    private Label dataCriacao;
    @FXML
    private TextField dataCriacaoField;
}
