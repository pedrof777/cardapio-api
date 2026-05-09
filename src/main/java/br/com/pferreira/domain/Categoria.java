package br.com.pferreira.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pedro Ferreira
 */

@Entity
@Table(name = "TB_CATEGORIA")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Nome é obrigatório")
  @Column(nullable = false, unique = true)
  private String nome;

  @Column
  private String descricao;
}
