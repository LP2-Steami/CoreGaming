package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.Models.DAO.DAOFactory;
import com.projetolp2.coregaming.Models.Entities.Usuario;
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

public class CriarPefilController {
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

    public void fotoOnClicked(){
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(LojaController.getStage().getScene().getWindow());
        if(file!=null){
            imgUsuario.setImage(new Image(file.getAbsolutePath()));
        }
    }

    public void onCriarClicked() throws SQLException, ClassNotFoundException {
        Usuario usuario = new Usuario();
        usuario.setNome(nomeUsuario.getText());
        usuario.setEmail(emailUsuario.getText());
        usuario.setSenha(senhaUsuario.getText());
        usuario.setDataCriacao(LocalDate.now());

        DAOFactory.createUsuarioDao().inserir(usuario);
        Alertas.mostrarAlerta(null,null,"Usuário atualizado com sucesso!", Alert.AlertType.INFORMATION);
    }
}
