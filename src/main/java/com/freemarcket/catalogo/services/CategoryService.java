
package com.freemarcket.catalogo.services;

import com.freemarcket.catalogo.entities.Category;
import com.freemarcket.catalogo.repositories.CategoryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRespository respository;

    @Transactional(readOnly = true)
    public List<Category> findAll() {
        return respository.findAll();
    }

}
