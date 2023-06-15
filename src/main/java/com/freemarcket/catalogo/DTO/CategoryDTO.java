package com.freemarcket.catalogo.DTO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.freemarcket.catalogo.entities.Category;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor


public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter @Setter private Long id;
    @Getter @Setter private String name;

    @Getter @Setter private Set<ProductDTO> products = new HashSet<>();

    public CategoryDTO (Category entity){
        id=entity.getId();
        name=entity.getName();
    }



}
