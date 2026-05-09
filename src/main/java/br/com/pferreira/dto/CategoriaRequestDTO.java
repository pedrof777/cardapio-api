package br.com.pferreira.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * @author Pedro Ferreira
 */

@Data
public class CategoriaRequestDTO {

  @NotBlank(message = "Nome é obrigatório")
  private String nome;

  private String descricao;
}
