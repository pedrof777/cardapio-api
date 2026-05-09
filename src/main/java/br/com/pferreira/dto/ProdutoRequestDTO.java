package br.com.pferreira.dto;

import br.com.pferreira.domain.Categoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Pedro Ferreira
 */

@Data
public class ProdutoRequestDTO {

  @NotBlank(message = "Nome é obrigatório")
  private String nome;

  private String descricao;

  @NotNull(message = "Preço é obrigatório")
  private BigDecimal preco;

  private String imagemUrl;

  private Boolean disponivel;

  @NotNull(message = "Categoria é obrigatória")
  private Long categoriaId;
}
