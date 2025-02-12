package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.Models.DAO.DAOFactory;
import com.projetolp2.coregaming.Models.DAO.UsuarioDAOJDBC;
import com.projetolp2.coregaming.Models.Entities.Jogo;
import com.projetolp2.coregaming.Util.SessaoUsuario;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.sql.SQLException;

public class TelaJogoController {

    @FXML
    private Label nomeJogo;

    @FXML
    private Label descricao;

    @FXML
    private Label dataLancamento;

    @FXML
    private Label preco;

    @FXML
    private Button adicionarCarrinho;

    private SessaoUsuario usuario = SessaoUsuario.getInstance();

    private Jogo jogo;

    private final CarrinhoController carrinhoController = new CarrinhoController();

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;

        nomeJogo.setText(jogo.getTitulo());
        descricao.setText(jogo.getDescricao());
        dataLancamento.setText(jogo.getDataLancamento().toString());
        preco.setText(String.format("%.2f", jogo.getPreco()));
    }

    @FXML
    public void onAdicionarCarrinhoClicked() throws SQLException, ClassNotFoundException {
        DAOFactory.createUsuarioDao().adicionarNoCarrinho(jogo, usuario);
        carrinhoController.adicionarJogoAoCarrinho(jogo);
    }
}
