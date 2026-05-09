package br.com.pferreira.repository;

import br.com.pferreira.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Pedro Ferreira
 */

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
