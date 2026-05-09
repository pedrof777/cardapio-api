package br.com.pferreira.service;

import br.com.pferreira.config.JwtService;
import br.com.pferreira.domain.Usuario;
import br.com.pferreira.dto.LoginRequestDTO;
import br.com.pferreira.dto.LoginResponseDTO;
import br.com.pferreira.dto.RegisterRequestDTO;
import br.com.pferreira.exception.ResourceNotFoundException;
import br.com.pferreira.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Pedro Ferreira
 */

@Service
@RequiredArgsConstructor
public class AuthService {

  private final UsuarioRepository usuarioRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;

  public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){
    Usuario usuario = usuarioRepository.findByEmail(loginRequestDTO.getEmail())
            .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado"));

    if(!passwordEncoder.matches(loginRequestDTO.getSenha(), usuario.getSenha())){
      throw new ResourceNotFoundException("Senha incorreta");
    };

    String token = jwtService.gerarToken(usuario.getEmail(), usuario.getRole().name());
    return new LoginResponseDTO(token, usuario.getEmail(), usuario.getRole().name());
  }

  public LoginResponseDTO register(RegisterRequestDTO registerRequestDTO){
    Usuario usuario = new Usuario();
    usuario.setEmail(registerRequestDTO.getEmail());
    usuario.setSenha(passwordEncoder.encode(registerRequestDTO.getSenha()));
    usuario.setRole(Usuario.Role.valueOf(registerRequestDTO.getRole().toUpperCase()));
    usuarioRepository.save(usuario);

    String token = jwtService.gerarToken(usuario.getEmail(), usuario.getRole().name());
    return new LoginResponseDTO(token, usuario.getEmail(), usuario.getRole().name());
  }
}
