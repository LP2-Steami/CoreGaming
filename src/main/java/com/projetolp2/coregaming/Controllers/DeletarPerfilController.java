package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.AplicacaoBase;
import com.projetolp2.coregaming.Models.DAO.DAOFactory;
import com.projetolp2.coregaming.Util.SessaoUsuario;

import java.io.IOException;
import java.sql.SQLException;

public class DeletarPerfilController {

    private final SessaoUsuario sessaoUsuario = SessaoUsuario.getInstance();

    public void onConfirmarButtonClicked() throws SQLException, ClassNotFoundException, IOException {
        DAOFactory.createUsuarioDao().deletar(sessaoUsuario);
        AplicacaoBase.newStage("login.fxml", "Logar perfil.");
    }
}
