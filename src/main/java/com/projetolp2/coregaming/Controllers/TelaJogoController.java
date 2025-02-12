package com.projetolp2.coregaming.Controllers;

import com.projetolp2.coregaming.Models.Entities.Jogo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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

    private Jogo jogo;

    public void mostrarInfo() {
        nomeJogo.setText(jogo.getTitulo());
        descricao.setText(jogo.getDescricao());
        dataLancamento.setText(jogo.getDataLancamento().toString());
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }
}
