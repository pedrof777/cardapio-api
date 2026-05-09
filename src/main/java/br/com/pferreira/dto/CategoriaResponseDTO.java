package br.com.pferreira.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Pedro Ferreira
 */

@Data
@AllArgsConstructor
public class CategoriaResponseDTO {

  private Long id;
  private String nome;
  private String descricao;

}
