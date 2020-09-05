/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtruck.api.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mtruck.api.entities.Produto;
import mtruck.api.services.CadastraProdutoService;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author GERU\christian.seki
 */
@RequestMapping("/produto")
@RestController
public class ProdutoController {

    @GetMapping
    List<Produto> listar() throws FileNotFoundException, UnsupportedEncodingException {

        Produto p1 = new Produto(1, "Roupa", "Playboy", "M", "Blusa Gola Polo", "Preto", 200.2, 245.4, 350.2, "Rua João Gomes", new Date());

        Produto p2 = new Produto(2, "Roupa", "Playboy", "M", "Blusa Gola Polo", "Preto", 200.2, 245.4, 350.2, "Rua João Gomes", new Date());

        List<Produto> produtos = new ArrayList<Produto>();

        produtos.add(p1);
        produtos.add(p2);

        return produtos;
    }

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    Produto cadastrar(@RequestBody Produto newProduto) {
        
        CadastraProdutoService cadastroService = new CadastraProdutoService();
        
        Produto produtoCriado = cadastroService.executa(newProduto);
        
        return produtoCriado;
    }

    @GetMapping("/{id}")
    Produto pesquisar(@PathVariable int id) {
        return new Produto(1, "Roupa", "Playboy", "M", "Blusa Gola Polo", "Preto", 200.2, 245.4, 350.2, "Rua João Gomes", new Date());
    }

    @PatchMapping("/{id}")
    Produto editar(@RequestBody Produto newProduto, @PathVariable int id) {
        newProduto.setId(id);
        return newProduto;
    }

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void deletar(@PathVariable int id) {

    }
}
