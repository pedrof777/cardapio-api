package br.com.pferreira.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author Pedro Ferreira
 */

@Data
@AllArgsConstructor
public class ProdutoResponseDTO {

  private Long id;
  private String nome;
  private String descricao;
  private BigDecimal preco;
  private String imagemUrl;
  private Boolean disponivel;
  private String categoriaNome;
}
