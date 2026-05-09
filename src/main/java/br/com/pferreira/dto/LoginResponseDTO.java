package br.com.pferreira.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Pedro Ferreira
 */

@Data
@AllArgsConstructor
public class LoginResponseDTO {

  private String Token;
  private String email;
  private String role;
}
