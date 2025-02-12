package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.AplicacaoBase;
import com.projetolp2.coregaming.DB.ConnectionDB;
import com.projetolp2.coregaming.Models.Entities.Jogo;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LojaController {

    @FXML
    private ImageView AC2;
    public void mostrarAC() throws IOException {
        mostrarJogo(AC2);
    }
    @FXML
    private ImageView ER;
    public void mostrarER() throws IOException {
        mostrarJogo(ER);
    }
    @FXML
    private ImageView DS;
    public void mostrarDS() throws IOException {
        mostrarJogo(DS);
    }
    @FXML
    private ImageView DS3;
    public void mostrarDS3() throws IOException {
        mostrarJogo(DS3);
    }
    @FXML
    private ImageView K;
    public void mostrarK() throws IOException {
        mostrarJogo(K);
    }
    @FXML
    private ImageView MC;
    public void mostrarMC() throws IOException {
        mostrarJogo(MC);
    }
    @FXML
    private ImageView V;
    public void mostrarV() throws IOException {
        mostrarJogo(V);
    }
    @FXML
    private ImageView DBZBT3;
    public void mostrarDBZBT3() throws IOException {
        mostrarJogo(DBZBT3);
    }
    @FXML
    private ImageView RE7;
    public void mostrarRE7() throws IOException {
        mostrarJogo(RE7);
    }
    @FXML
    private ImageView JCS;
    public void mostrarJCS() throws IOException {
        mostrarJogo(JCS);
    }
    @FXML
    private ImageView D4;
    public void mostrarD4() throws IOException {
        mostrarJogo(D4);
    }
    @FXML
    private ImageView TLOU;
    public void mostrarTLOU() throws IOException {
        mostrarJogo(TLOU);
    }
    @FXML
    private ImageView H;
    public void mostrarH() throws IOException {
        mostrarJogo(H);
    }
    @FXML
    private ImageView HK;
    public void mostrarHK() throws IOException {
        mostrarJogo(HK);
    }
    @FXML
    private ImageView GOW2;
    public void mostrarGOW2() throws IOException {
        mostrarJogo(GOW2);
    }
    @FXML
    private ImageView TW3;
    public void mostrarTW3() throws IOException {
        mostrarJogo(TW3);
    }
    @FXML
    private ImageView T;
    public void mostrarT() throws IOException {
        mostrarJogo(T);
    }


    public void mostrarJogo(ImageView imageView) throws IOException {
        Connection connection = null;
        PreparedStatement psJogo = null;
        ResultSet rs = null;
        String sku = null;

        try {
            connection = ConnectionDB.getConnection();
            psJogo = connection.prepareStatement("SELECT * FROM jogo WHERE sku = ?");
            psJogo.setString(1, imageView.getId());
            rs = psJogo.executeQuery();

            if (rs.next()) {
                System.out.println("informacao do jogo: " + rs.getString("sku"));
                Jogo jogo = new Jogo();
                jogo.setId_jogo(rs.getInt("id_jogo"));
                jogo.setTitulo(rs.getString("titulo"));
                jogo.setDescricao(rs.getString("descricao"));
                jogo.setPreco(rs.getFloat("preco"));
                jogo.setDataLancamento(rs.getDate("data_lancamento"));
                AplicacaoBase.novaTelaJogo("telaJogo.fxml", "Informações do jogo: " + rs.getString("titulo"), jogo);
            }

        } catch (SQLException e) {
                throw new RuntimeException(e);
        }
    }

    @FXML
    public void onLojaButtonClicked() throws IOException {
        AplicacaoBase.newStage("loja.fxml", "Loja");
    }
    @FXML
    public void onBibliotecaButtonClicked() throws IOException {
        AplicacaoBase.newStage("biblioteca.fxml", "Biblioteca");
    }
    @FXML
    public void onVerPerfilButtonClicked() throws IOException {
        AplicacaoBase.novaTela("perfil.fxml", "Perfil do Usuário");
    }
    @FXML
    public void onAtualizarPerfilButtonClicked() throws IOException {
        AplicacaoBase.novaTela("atualizar-perfil.fxml", "Atualizar Perfil");
    }
    @FXML
    public void onCarrinhoButtonClicked() throws IOException {
        AplicacaoBase.novaTela("carrinho.fxml", "Carrinho");
    }
    @FXML
    public void onDeletarPerfilClicked() throws IOException {
            AplicacaoBase.novaTela("confirmar-deletar.fxml", "Deletar perfil");
    }
    @FXML
    public void onSairButtonClicked() throws IOException {
        AplicacaoBase.newStage("login.fxml", "Logar perfil");
    }
}
