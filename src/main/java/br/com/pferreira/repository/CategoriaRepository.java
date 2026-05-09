package br.com.pferreira.repository;

import br.com.pferreira.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pedro Ferreira
 */

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
