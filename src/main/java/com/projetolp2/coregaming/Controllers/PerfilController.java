package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.AplicacaoBase;
import com.projetolp2.coregaming.Models.DAO.DAOFactory;
import com.projetolp2.coregaming.Models.DAO.DAOUsuario;
import com.projetolp2.coregaming.Models.Entities.Usuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.sql.SQLException;

public class PerfilController {
    @FXML
    private Button botaoDeletar;
    @FXML
    private ImageView imgUsuario;
    @FXML
    private TextField nomeUsuarioField;
    @FXML
    private TextField emailUsuarioField;
    @FXML
    private TextField senhaUsuarioField;
    @FXML
    private TextField dataCriacaoField;
    private Usuario usuario;


    public void onDeletarButtonClicked() throws SQLException, ClassNotFoundException, IOException {
        DAOFactory.createUsuarioDao().deletar(usuario);
        AplicacaoBase.newStage("login.fxml", "Logar perfil.");
    }
}
