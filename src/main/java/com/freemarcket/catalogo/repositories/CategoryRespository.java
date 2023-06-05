
package com.freemarcket.catalogo.repositories;

import com.freemarcket.catalogo.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRespository extends JpaRepository<Category, Long> {

}
