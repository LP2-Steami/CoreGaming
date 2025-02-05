package com.projetolp2.coregaming.Models.DAO;

import com.projetolp2.coregaming.DB.ConnectionDB;
import com.projetolp2.coregaming.Models.Entities.Usuario;
import com.projetolp2.coregaming.Util.Alertas;
import javafx.scene.control.Alert;

import java.sql.*;


public class UsuarioDAOJDBC implements DAOUsuario {
    private final Connection conn;
    PreparedStatement psChecarUsuarioExistente = null;
    ResultSet resultSet = null;
    UsuarioDAOJDBC(Connection conn){
        this.conn = conn;
    }
    public void inserir(Usuario usuario) throws SQLException {

        String insert = "INSERT INTO Usuario (nome, email, senha, data_criacao) VALUES (?,?,?,?)";
        PreparedStatement statement = null;
        psChecarUsuarioExistente = conn.prepareStatement("SELECT * FROM usuario WHERE email = ?");
        psChecarUsuarioExistente.setString(1, usuario.getEmail());
        resultSet = psChecarUsuarioExistente.executeQuery();

        try {
            if (resultSet.isBeforeFirst()){
                System.out.println("Email já cadastrado!");
                Alertas.mostrarAlerta("Email já cadastrado", null, "Você não pode utilizar este email.", Alert.AlertType.ERROR);
            } else {
                statement = conn.prepareStatement(insert);
                statement.setString(1, usuario.getNome());
                statement.setString(2, usuario.getEmail());
                statement.setString(3, usuario.getSenha());
                statement.setDate(4, Date.valueOf(usuario.getDataCriacao()));
            }

            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (psChecarUsuarioExistente != null) {
                try {
                    psChecarUsuarioExistente.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            ConnectionDB.closeConnection();
        }
    }
    public void atualizar(Usuario usuario) {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(
                    "UPDATE usuario " +
                            "SET nome = ?, " +
                            "email = ?"+
                            "senha = ?,"+
                            "dataCriacao = ?,"+
                            "foto = ?"+
                            "WHERE id = ?");


            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            statement.setInt(6, usuario.getId());
            statement.executeUpdate();
            Alertas.mostrarAlerta(null,null,"Usuário cadastrado com sucesso!", Alert.AlertType.INFORMATION);


        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar usuário!", e);
        } finally {
            ConnectionDB.closeStatement(statement);
        }
    }
    public void deletar(Usuario usuario) {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(
                    "DELETE FROM usuario WHERE id = ?");

            statement.setInt(1, usuario.getId());

            statement.executeUpdate();
            Alertas.mostrarAlerta(null,null,"Usuário deletado com sucesso!", Alert.AlertType.INFORMATION);

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir usuário!", e);
        } finally {
            ConnectionDB.closeStatement(statement);
        }
    }

    }
