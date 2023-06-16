package com.freemarcket.catalogo.services;

import com.freemarcket.catalogo.DTO.CartDTO;
import com.freemarcket.catalogo.DTO.ProductDTO;
import com.freemarcket.catalogo.entities.Cart;
import com.freemarcket.catalogo.entities.Product;
import com.freemarcket.catalogo.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CartService {
    private final Cart carrinhoDeCompras;
    private final ProductService productService;
    private final CartRepository cartRepository;

    @Autowired
    public CartService(ProductService productService, CartRepository cartRepository) {
        this.carrinhoDeCompras = new Cart(new ArrayList<>());
        this.productService = productService;
        this.cartRepository = cartRepository;
    }

    public void adicionarProdutoAoCarrinho(Long produtoId) {
        ProductDTO produtoDTO = productService.findById(produtoId);
        Product produto = convertToEntity(produtoDTO);
        carrinhoDeCompras.adicionarProduto(produto);
    }

    public void removerProdutoDoCarrinho(Long produtoId) {
        ProductDTO produtoDTO = productService.findById(produtoId);
        Product produto = convertToEntity(produtoDTO);
        carrinhoDeCompras.removerProduto(produto);
    }

    public CartDTO getCarrinhoDeCompras() {
        List<ProductDTO> produtoDTOs = carrinhoDeCompras.getProdutos().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
        return new CartDTO(carrinhoDeCompras.getId(), produtoDTOs);
    }

    public void salvarCarrinhoNoBancoDeDados() {
        Cart cart = cartRepository.findById(1L).orElse(null);
        if (cart == null) {
            cart = new Cart(new ArrayList<>());

        }
        List<Product> produtos = carrinhoDeCompras.getProdutos();
        for (Product produto : produtos) {
            if (!cart.getProdutos().contains(produto)) {
                cart.adicionarProduto(produto);
            }
        }
        cartRepository.save(cart);
    }

    private Product convertToEntity(ProductDTO productDTO) {
        Product produto = new Product();
        produto.setName(productDTO.getName());
        produto.setDescription(productDTO.getDescription());
        produto.setPrice(productDTO.getPrice());
        return produto;
    }

    private ProductDTO convertToDTO(Product product) {

        ProductDTO produtoDTO = new ProductDTO();
        produtoDTO.setId(product.getId());
        produtoDTO.setName(product.getName());
        produtoDTO.setDescription(product.getDescription());
        produtoDTO.setPrice(product.getPrice());
        return produtoDTO;
    }
}



