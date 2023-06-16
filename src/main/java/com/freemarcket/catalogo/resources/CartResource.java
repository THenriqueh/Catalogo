package com.freemarcket.catalogo.resources;

import com.freemarcket.catalogo.DTO.CartDTO;
import com.freemarcket.catalogo.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/carrinho")
public class CartResource {
    private final CartService cartService;

    @Autowired
    public CartResource(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping(value = "/adicionar/{produtoId}")
    public ResponseEntity<String> adicionarProduto(@PathVariable Long produtoId) {
        cartService.adicionarProdutoAoCarrinho(produtoId);
        return ResponseEntity.ok().body("Produto adicionado ao carrinho com sucesso!");
    }

    @PostMapping(value = "/remover/{produtoId}")
    public ResponseEntity<String> removerProduto(@PathVariable Long produtoId) {
        cartService.removerProdutoDoCarrinho(produtoId);
        return ResponseEntity.ok().body("Produto removido do carrinho com sucesso!");
    }

    @GetMapping
    public ResponseEntity<CartDTO> getCarrinhoDeCompras() {
        CartDTO carrinho = cartService.getCarrinhoDeCompras();
        return ResponseEntity.ok().body(carrinho);
    }
}

