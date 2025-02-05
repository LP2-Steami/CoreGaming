package com.projetolp2.coregaming.Models.DAO;

import com.projetolp2.coregaming.Models.Entities.Usuario;

import java.sql.SQLException;

public interface DAOUsuario {
    void inserir(Usuario usuario) throws SQLException;
    void atualizar(Usuario usuario);
    void deletar(Usuario usuario);
}
