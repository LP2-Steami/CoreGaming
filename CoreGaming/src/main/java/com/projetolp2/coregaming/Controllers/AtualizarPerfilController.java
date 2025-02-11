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
    @FXML
    private Image foto;
    private File file;
    private Usuario usuario;
    private LocalDate data;

    public byte[] fotoOnClicked(){
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(AplicacaoBase.getStage().getScene().getWindow());
        if(file!=null){
            imgUsuario.setImage(new Image(file.getAbsolutePath()));
        }
        return null;
    }

    public void onAtualizarClick() throws SQLException, ClassNotFoundException {
        usuario.setNome(nomeUsuarioField.getText());
        usuario.setEmail(emailUsuarioField.getText());
        usuario.setSenha(senhaUsuarioField.getText());
        usuario.setFoto(fotoOnClicked());

        DAOFactory.createUsuarioDao().atualizar(usuario);
        Alertas.mostrarAlerta(null,null,"Usuário atualizado com sucesso!", Alert.AlertType.INFORMATION);
    }
}
