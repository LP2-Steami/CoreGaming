package com.projetolp2.coregaming.Models.DAO;

import com.projetolp2.coregaming.DB.ConnectionDB;

import java.sql.SQLException;

public interface DAOFactory {
    public static DAOUsuario createUsuarioDao() throws SQLException, ClassNotFoundException {
        return new UsuarioDAOJDBC(ConnectionDB.getConnection());
    }
}
