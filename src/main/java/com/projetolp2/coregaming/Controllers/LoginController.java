package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.AplicacaoBase;
import com.projetolp2.coregaming.DB.ConnectionDB;
import com.projetolp2.coregaming.Models.Entities.Usuario;
import com.projetolp2.coregaming.Util.Alertas;
import com.projetolp2.coregaming.Util.SessaoUsuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController{
    @FXML
    private Label loginMessageLabel;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField senhaField;

    @FXML
    public void onLinkCadastrarClicked() throws IOException {
        AplicacaoBase.newStage("criar-perfil.fxml", "Criar perfil");
    }

    @FXML
    private void onEntrarButtonClicked(ActionEvent e) {
        if (emailField.getText().isBlank() && senhaField.getText().isBlank()) {
            loginMessageLabel.setText("Insira suas credências antes!");
        } else if (!emailField.getText().isBlank() && senhaField.getText().isBlank()) {
            loginMessageLabel.setText("Insira email e senha para entrar!");
        } else {
            validarLogin(emailField.getText(), senhaField.getText());
        }
    }

    public void validarLogin(String email, String senha) {
        Connection connection = null;
        PreparedStatement psChecarSenha = null;
        ResultSet resultados = null;

        try {
            connection = ConnectionDB.getConnection();
            psChecarSenha = connection.prepareStatement("SELECT * FROM usuario WHERE email = ?");
            psChecarSenha.setString(1, email);
            resultados = psChecarSenha.executeQuery();

            if (!resultados.isBeforeFirst()) {
                System.out.println("Usuário não encontrado!");
                Alertas.mostrarAlerta("Usuário não encontrado!",null,"Credenciais não encontradas!", Alert.AlertType.ERROR);
            } else {
                while (resultados.next()) {
                    String senhaRetornada = resultados.getString("senha");
                    if (senhaRetornada.equals(senha)) {
                        int idUsuario = resultados.getInt("id_usuario");

                        // Criar objeto usuário
                        Usuario usuario = new Usuario();
                        usuario.setId(idUsuario);
                        usuario.setEmail(email);
                        usuario.setSenha(senha);
                        usuario.setNome(resultados.getString("nome"));
//                        usuario.setFoto(resultados.getBytes("foto"));
                        usuario.setDataCriacao(resultados.getDate("data_criacao").toLocalDate());

                        // Armazenar na sessão
                        SessaoUsuario.getInstance().setUsuarioLogado(usuario);

                        System.out.println("Usuário logado: " + idUsuario);
                        AplicacaoBase.newStage("loja.fxml", "Loja");
                    } else {
                        System.out.println("As senhas não correspondem!");
                        Alertas.mostrarAlerta("Senhas diferentes!", null, "Senhas incorrespondentes!", Alert.AlertType.ERROR);
                    }
                }
            }
        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
