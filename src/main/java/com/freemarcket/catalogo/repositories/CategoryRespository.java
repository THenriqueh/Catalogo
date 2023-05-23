
package com.freemarcket.catalogo.repositories;

import com.freemarcket.catalogo.entities.Category;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Repository
public interface CategoryRespository extends JpaRepository<Category, Long> {

}
