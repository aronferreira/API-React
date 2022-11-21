package com.projetoapireact.projetoAPIReact.controle;

import com.projetoapireact.projetoAPIReact.modelo.ProdutoModelo;
import com.projetoapireact.projetoAPIReact.modelo.RespostaModelo;
import com.projetoapireact.projetoAPIReact.servico.ProdutoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class ProdutoControle {
    @Autowired
    private ProdutoServico servico;

    @GetMapping("/produtos")
    public Iterable<ProdutoModelo> listarProdutos() {
        return servico.listarProdutos();
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrarProdutos(@RequestBody ProdutoModelo produto) {
        return servico.cadastrarAlterarProdutos(produto, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterarProdutos(@RequestBody ProdutoModelo produto) {
        return servico.cadastrarAlterarProdutos(produto, "alterar");
    }

    @DeleteMapping("/apagar/{id}")
    public ResponseEntity<RespostaModelo>  apagarProdutos(@PathVariable long id) {
        return servico.removerProduto(id);
    }



}
