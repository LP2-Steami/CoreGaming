package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.AplicacaoBase;
import com.projetolp2.coregaming.Models.Entities.Usuario;
import com.projetolp2.coregaming.Models.DAO.DAOFactory;


import com.projetolp2.coregaming.Util.Alertas;
import com.projetolp2.coregaming.Util.SessaoUsuario;
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
    private TextField nomeUsuarioField;
    @FXML
    private TextField emailUsuarioField;
    @FXML
    private TextField senhaUsuarioField;

    private final SessaoUsuario sessaoUsuario = SessaoUsuario.getInstance();

    public void mostrarDados() {
        nomeUsuarioField.setText(sessaoUsuario.getUsuarioLogado().getNome());
        emailUsuarioField.setText(sessaoUsuario.getUsuarioLogado().getEmail());
        senhaUsuarioField.setText(sessaoUsuario.getUsuarioLogado().getSenha());
    }

    public void onAtualizarClick() throws SQLException, ClassNotFoundException {
        sessaoUsuario.getUsuarioLogado().setNome(nomeUsuarioField.getText());
        sessaoUsuario.getUsuarioLogado().setEmail(emailUsuarioField.getText());
        sessaoUsuario.getUsuarioLogado().setSenha(senhaUsuarioField.getText());

        DAOFactory.createUsuarioDao().atualizar(sessaoUsuario);
        Alertas.mostrarAlerta(null,null,"Usuário atualizado com sucesso!", Alert.AlertType.INFORMATION);
    }
}
