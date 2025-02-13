package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.AplicacaoBase;
import com.projetolp2.coregaming.Models.DAO.DAOFactory;
import com.projetolp2.coregaming.Models.Entities.Usuario;
import com.projetolp2.coregaming.Util.Alertas;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CriarPefilController {
    @FXML
    public Label cadastroMessageLabel;
    @FXML
    private Label nomeUsuario;
    @FXML
    private TextField nomeField;
    @FXML
    private Label emailUsuario;
    @FXML
    private TextField emailField;
    @FXML
    private Label senhaUsuario;
    @FXML
    private PasswordField senhaField;
    @FXML
    private Button criar;
    @FXML
    private Hyperlink logar;
    private Usuario usuario;
    private LocalDate data;

    public void onCriarClicked() throws SQLException, ClassNotFoundException, IOException {
        Usuario usuario = new Usuario();
        usuario.setNome(nomeField.getText());
        usuario.setEmail(emailField.getText());
        usuario.setSenha(senhaField.getText());
        usuario.setDataCriacao(LocalDate.now());

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$");
        Matcher matcher = pattern.matcher(usuario.getEmail());
        if (!matcher.matches()) {
            Alertas.mostrarAlerta("Email Inválido!", null, "Formato de e-mail Inválido!", Alert.AlertType.ERROR);
            throw new Error("email invalido");
        }

        DAOFactory.createUsuarioDao().inserir(usuario);
        Alertas.mostrarAlerta("Sucesso!",null,"Usuário Criado com sucesso!", Alert.AlertType.CONFIRMATION);
        AplicacaoBase.newStage("login.fxml", "Logar perfil");
    }

    public void onLogarClicked() throws IOException {
        AplicacaoBase.newStage("login.fxml", "Logar perfil");
    }
}
