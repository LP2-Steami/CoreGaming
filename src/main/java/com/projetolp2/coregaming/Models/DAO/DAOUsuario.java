package com.projetolp2.coregaming.Models.DAO;

import com.projetolp2.coregaming.Models.Entities.Jogo;
import com.projetolp2.coregaming.Models.Entities.Transacao;
import com.projetolp2.coregaming.Models.Entities.Usuario;
import com.projetolp2.coregaming.Util.SessaoUsuario;

import java.sql.SQLException;
import java.util.ArrayList;

public interface DAOUsuario {
    void inserir(Usuario usuario) throws SQLException;
    void atualizar(SessaoUsuario usuario);
    void deletar(SessaoUsuario usuario);
    void adicionarNoCarrinho(Jogo jogo, SessaoUsuario usuarioSessao);
    void transacaoJogo(Jogo jogo, int idTransacao, SessaoUsuario usuario);
    void comprar(Jogo jogo, SessaoUsuario usuario);
    void removerDoCarrinho(Jogo jogo, SessaoUsuario usuario);
    void removerTransacaoJogo(Jogo jogo, SessaoUsuario usuario);
}
