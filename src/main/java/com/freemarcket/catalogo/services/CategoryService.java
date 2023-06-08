
package com.freemarcket.catalogo.services;

import com.freemarcket.catalogo.DTO.CategoryDTO;
import com.freemarcket.catalogo.entities.Category;
import com.freemarcket.catalogo.repositories.CategoryRespository;
import com.freemarcket.catalogo.services.excptions.DatabaseException;
import com.freemarcket.catalogo.services.excptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRespository respository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> list = respository.findAll();
        return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> obj = respository.findById(id);
        Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO insert(CategoryDTO categoryDTO) {
        Category entity = new Category();
        entity.setName(categoryDTO.getName());
        respository.save(entity);
        return new CategoryDTO(entity);
    }
    @Transactional
    public CategoryDTO update(Long id, CategoryDTO categoryDTO) {

        try {
            Category entity = respository.getReferenceById(id);
            entity.setName(categoryDTO.getName());
            entity = respository.save(entity);
            return new CategoryDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id '" + id + "' não encontrado");

        }

    }

    public void delete(Long id) {
        try {
            respository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("Id '" + id + "' não encontrado");
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException("Você não pode exluir uma categoria com Produtos cadastrados");
        }


    }

}
