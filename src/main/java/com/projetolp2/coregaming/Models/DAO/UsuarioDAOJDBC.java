package com.projetolp2.coregaming.Models.DAO;

import com.projetolp2.coregaming.DB.ConnectionDB;
import com.projetolp2.coregaming.Models.Entities.Jogo;
import com.projetolp2.coregaming.Models.Entities.Transacao;
import com.projetolp2.coregaming.Models.Entities.Usuario;
import com.projetolp2.coregaming.Util.Alertas;
import com.projetolp2.coregaming.Util.SessaoUsuario;
import javafx.scene.control.Alert;

import java.sql.*;
import java.time.LocalDate;


public class UsuarioDAOJDBC implements DAOUsuario {
    private int quantidade;
    private double valorTotal;
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
    public void atualizar(SessaoUsuario usuario) {
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


            statement.setString(1, usuario.getUsuarioLogado().getNome());
            statement.setString(2, usuario.getUsuarioLogado().getEmail());
            statement.setString(3, usuario.getUsuarioLogado().getSenha());
            statement.setInt(6, usuario.getUsuarioLogado().getId());
            statement.executeUpdate();
            Alertas.mostrarAlerta(null,null,"Usuário cadastrado com sucesso!", Alert.AlertType.INFORMATION);


        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar usuário!", e);
        } finally {
            ConnectionDB.closeStatement(statement);
        }
    }
    public void deletar(SessaoUsuario usuario) {
        PreparedStatement statement = null;
        try {
            statement = conn.prepareStatement(
                    "DELETE FROM usuario WHERE id_usuario = ?");

            statement.setInt(1, SessaoUsuario.getInstance().getUsuarioLogado().getId());

            statement.executeUpdate();
            Alertas.mostrarAlerta(null,null,"Usuário deletado com sucesso!", Alert.AlertType.INFORMATION);

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao excluir usuário!", e);
        } finally {
            ConnectionDB.closeStatement(statement);
        }
    }
    public void adicionarNoCarrinho(Jogo jogo, SessaoUsuario usuario){
        PreparedStatement statement = null;
        ResultSet rs = null;
        int id_transa = 0;

        valorTotal+= jogo.getPreco();

        String insertCarrinho = "INSERT INTO Transacao (id_usuario, data_transacao, quantidade) VALUES (?,?,?)";
        quantidade +=1;

        try {
            ConnectionDB.getConnection();
            statement = conn.prepareStatement(insertCarrinho, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setInt(1, usuario.getUsuarioLogado().getId());
            statement.setDate(2, Date.valueOf(LocalDate.now()));
            statement.setInt(3, quantidade);
            boolean linhasAfetadas = statement.executeUpdate() > 0; // Retorna o número de linhas afetadas

            if (linhasAfetadas) {
                rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    id_transa = rs.getInt(1);
                } else {
                    throw new SQLException("Erro na criação da transação!");
                }
            }

            transacaoJogo(jogo, id_transa, usuario);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeStatement(statement);
        }

    }
    public void transacaoJogo(Jogo jogo, int idTransacao, SessaoUsuario usuario){
        PreparedStatement statement = null;
        String insertTransacaoJogo = "INSERT INTO Transacao_jogo (id_jogo, preco_unitario, id_transacao) VALUES (?,?,?)";

        try {
            ConnectionDB.getConnection();
            statement = conn.prepareStatement(insertTransacaoJogo);
            statement.setInt(1, jogo.getId_jogo());
            statement.setDouble(2, jogo.getPreco());
            statement.setInt(3, idTransacao);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeStatement(statement);
        }
    }

    @Override
    public void comprar(Jogo jogo, SessaoUsuario usuario) {
        PreparedStatement statement = null;
        String inserirBiblioteca = "INSERT INTO Transacao_jogo (id_usuario, id_jogo, data_adicionar, foto_jogo) VALUES (?,?,?,?)";

        try {
            statement = conn.prepareStatement(inserirBiblioteca);
            statement.setInt(1, usuario.getUsuarioLogado().getId());
            statement.setInt(2, jogo.getId_jogo());
            statement.setString(3, String.valueOf(LocalDate.now()));
            statement.setBytes(4, jogo.getFoto());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removerDoCarrinho(Jogo jogo, SessaoUsuario usuario) {
        PreparedStatement statement = null;

        String removerDocarrinho = "DELETE FROM transacao WHERE id_usuario = ?";

        valorTotal-= jogo.getPreco();

        try {
            ConnectionDB.getConnection();
            statement = conn.prepareStatement(removerDocarrinho);
            statement.setInt(1,usuario.getUsuarioLogado().getId() );
            removerTransacaoJogo(jogo, usuario);
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeStatement(statement);
        }

    }

    @Override
    public void removerTransacaoJogo(Jogo jogo, SessaoUsuario usuario) {
        PreparedStatement statement = null;
        String removerDoCarrinho = "DELETE FROM transacao_jogo WHERE id_usuario = ?";
        try {
            ConnectionDB.getConnection();
            statement = conn.prepareStatement(removerDoCarrinho);
            statement.setInt(1,usuario.getUsuarioLogado().getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            ConnectionDB.closeStatement(statement);
        }
    }

}
