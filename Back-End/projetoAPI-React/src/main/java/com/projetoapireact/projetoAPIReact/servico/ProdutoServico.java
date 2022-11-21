package com.projetoapireact.projetoAPIReact.servico;

import com.projetoapireact.projetoAPIReact.modelo.ProdutoModelo;
import com.projetoapireact.projetoAPIReact.modelo.RespostaModelo;
import com.projetoapireact.projetoAPIReact.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServico {
    @Autowired
    private ProdutoRepositorio repositorio;
    @Autowired
    private RespostaModelo mensagem;

    public Iterable<ProdutoModelo> listarProdutos() {
        return repositorio.findAll();
    }

    public ResponseEntity<?> cadastrarAlterarProdutos(ProdutoModelo produto, String acao) {
        if (produto.getNome() == "") {
            mensagem.setMensagem("Erro, o nome do produto é obrigatório.");
            return new ResponseEntity<RespostaModelo>(mensagem, HttpStatus.BAD_REQUEST);
        } else if (produto.getMarca() == "") {
            mensagem.setMensagem("Erro, o nome da marca é obrigatório.");
            return new ResponseEntity<RespostaModelo>(mensagem, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
            return new ResponseEntity<ProdutoModelo>(repositorio.save(produto), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<ProdutoModelo>(repositorio.save(produto), HttpStatus.OK);
        }
    }
}

    public ResponseEntity<RespostaModelo> removerProduto(long codigo) {
        repositorio.deleteById(codigo);
        mensagem.setMensagem("O produto foi removido com sucesso.");
        return new ResponseEntity<RespostaModelo>(mensagem, HttpStatus.OK);
    }
}
