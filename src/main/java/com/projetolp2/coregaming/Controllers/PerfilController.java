package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.AplicacaoBase;
import com.projetolp2.coregaming.DB.ConnectionDB;
import com.projetolp2.coregaming.Models.DAO.DAOFactory;
import com.projetolp2.coregaming.Models.DAO.DAOUsuario;
import com.projetolp2.coregaming.Models.Entities.Usuario;
import com.projetolp2.coregaming.Util.Alertas;
import com.projetolp2.coregaming.Util.SessaoUsuario;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.EventListener;
import java.util.ResourceBundle;

public class PerfilController implements Initializable {
    @FXML
    public Button botaoConfirmarDeletar;
    @FXML
    public Button botaoDeletar;
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

    private final SessaoUsuario sessaoUsuario = SessaoUsuario.getInstance();

    public void mostrarDados() {
        nomeUsuarioField.setText(sessaoUsuario.getUsuarioLogado().getNome());
        emailUsuarioField.setText(sessaoUsuario.getUsuarioLogado().getEmail());
        senhaUsuarioField.setText(sessaoUsuario.getUsuarioLogado().getSenha());
        dataCriacaoField.setText(sessaoUsuario.getUsuarioLogado().getDataCriacao().toString());
        imgUsuario.setImage(sessaoUsuario.getUsuarioLogado().getFoto());
    }

    public void onDeletarButtonClicked() throws IOException {
        AplicacaoBase.novaTela("confirmar-deletar.fxml", "Tem certeza?");
    }

    public void onConfirmarButtonClicked() throws SQLException, ClassNotFoundException, IOException {
        DAOFactory.createUsuarioDao().deletar(sessaoUsuario.getUsuarioLogado());
        AplicacaoBase.newStage("login.fxml", "Logar perfil.");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mostrarDados();
    }
}
