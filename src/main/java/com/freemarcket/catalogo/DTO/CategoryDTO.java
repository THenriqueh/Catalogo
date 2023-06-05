package com.freemarcket.catalogo.DTO;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

// @Entity
// @Table(name = "tb_category")
public class CategoryDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Id
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
