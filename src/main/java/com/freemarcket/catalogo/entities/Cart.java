package com.freemarcket.catalogo.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tb_cart")
public class Cart {
    @Id
    
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "tb_cart_product",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @Setter private List<Product> produtos;

    public Cart() {
        this.produtos = new ArrayList<>();
    }

    public Cart(List<Product> produtos) {
        this.produtos = produtos;
    }

    public void adicionarProduto(Product produto) {
        produtos.add(produto);
    }

    public void removerProduto(Product produto) {
        produtos.remove(produto);
    }


}


