package br.com.pferreira.controller;

import br.com.pferreira.dto.LoginRequestDTO;
import br.com.pferreira.dto.LoginResponseDTO;
import br.com.pferreira.dto.RegisterRequestDTO;
import br.com.pferreira.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pedro Ferreira
 */

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/register")
  public ResponseEntity<LoginResponseDTO> resgiter(@RequestBody @Valid RegisterRequestDTO registerRequestDTO){
    return ResponseEntity.ok(authService.register(registerRequestDTO));
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO){
    return ResponseEntity.ok(authService.login(loginRequestDTO));
  }
}
