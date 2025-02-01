package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.AplicacaoBase;
import com.projetolp2.coregaming.Models.Entities.Usuario;
import com.projetolp2.coregaming.Models.DAO.DAOFactory;


import com.projetolp2.coregaming.Util.Alertas;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import java.io.File;
import java.sql.SQLException;
import java.time.LocalDate;


public class AtualizarPerfilController {
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
    private Button atualizar;
    private Usuario usuario;
    private LocalDate data;

    public ImageView getImgUsuario() {
        return imgUsuario;
    }

    public void setImgUsuario(ImageView imgUsuario) {
        this.imgUsuario = imgUsuario;
    }

    public Label getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(Label nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public TextField getNomeUsuarioField() {
        return nomeUsuarioField;
    }

    public void setNomeUsuarioField(TextField nomeUsuarioField) {
        this.nomeUsuarioField = nomeUsuarioField;
    }

    public Label getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(Label emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public TextField getEmailUsuarioField() {
        return emailUsuarioField;
    }

    public void setEmailUsuarioField(TextField emailUsuarioField) {
        this.emailUsuarioField = emailUsuarioField;
    }

    public Label getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(Label senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public TextField getSenhaUsuarioField() {
        return senhaUsuarioField;
    }

    public void setSenhaUsuarioField(TextField senhaUsuarioField) {
        this.senhaUsuarioField = senhaUsuarioField;
    }

    public void fotoOnClicked(){
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(LojaController.getStage().getScene().getWindow());
        if(file!=null){
            imgUsuario.setImage(new Image(file.getAbsolutePath()));
        }
    }

    public void onAtualizarClick() throws SQLException, ClassNotFoundException {
        usuario.setNome(nomeUsuario.getText());
        usuario.setEmail(emailUsuario.getText());
        usuario.setSenha(senhaUsuario.getText());

        DAOFactory.createUsuarioDao().atualizar(usuario);
        Alertas.mostrarAlerta(null,null,"Usuário atualizado com sucesso!", Alert.AlertType.INFORMATION);
    }
}
