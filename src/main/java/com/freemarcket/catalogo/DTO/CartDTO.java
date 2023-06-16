package com.freemarcket.catalogo.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CartDTO {
    private Long id;
    private List<ProductDTO> produtos;

    public CartDTO() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(ProductDTO produto) {
        produtos.add(produto);
    }

    public void removerProduto(ProductDTO produto) {
        produtos.remove(produto);
    }
}

