package br.com.pferreira.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author Pedro Ferreira
 */

@Entity
@Table(name = "TB_PRODUTOS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Produto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Nome é obrigatório")
  @Column(nullable = false)
  private String nome;

  @Column
  private String descricao;

  @NotNull(message = "Preço é obrigatório")
  @Column(nullable = false)
  private BigDecimal preco;

  @Column
  private String imagemUrl;

  @Column(nullable = false)
  private Boolean disponivel;

  @ManyToOne
  @JoinColumn(name = "CATEGORIA_ID", nullable = false)
  private Categoria categoria;

}
