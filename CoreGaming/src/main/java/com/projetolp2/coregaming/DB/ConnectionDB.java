package com.projetolp2.coregaming.DB;

import java.sql.*;

public class ConnectionDB {
    private static Connection conn = null;
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    public ConnectionDB(Connection conn){
        this.conn = conn;
    }


    public static Connection getConnection() {
        if (conn == null) {
            try {
                Class.forName("org.postgresql.Driver");
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("✅ Conexão bem-sucedida com o banco de dados!");
            } catch (ClassNotFoundException e) {
                System.err.println("🚨 Driver JDBC não encontrado!");
                e.printStackTrace();
            } catch (SQLException e) {
                System.err.println("🚨 Erro ao conectar ao banco de dados!");
                e.printStackTrace();
            }
        }
        return conn;
    }


    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                conn = null; // Resetar conexão
                System.out.println("✅ Conexão fechada com sucesso!");
            } catch (SQLException e) {
                System.err.println("🚨 Erro ao fechar a conexão!");
                e.printStackTrace();
            }
        }
    }
    public static void closeStatement(Statement st){
        if(st!=null){
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void closeResultSet(ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}