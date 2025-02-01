package com.projetolp2.coregaming.Models.DAO;

import com.projetolp2.coregaming.Models.Entities.Usuario;

public interface DAOUsuario {
    void inserir(Usuario usuario);
    void atualizar(Usuario usuario);
    void deletar(Usuario usuario);
}
