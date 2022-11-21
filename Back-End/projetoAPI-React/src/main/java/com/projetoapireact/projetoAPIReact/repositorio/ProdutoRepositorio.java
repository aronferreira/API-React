package com.projetoapireact.projetoAPIReact.repositorio;

import com.projetoapireact.projetoAPIReact.modelo.ProdutoModelo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Long> {
}
