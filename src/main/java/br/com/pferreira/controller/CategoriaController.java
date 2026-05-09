package br.com.pferreira.controller;

import br.com.pferreira.domain.Categoria;
import br.com.pferreira.dto.CategoriaRequestDTO;
import br.com.pferreira.dto.CategoriaResponseDTO;
import br.com.pferreira.service.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Pedro Ferreira
 */

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

  private final CategoriaService categoriaService;

  @PostMapping
  public ResponseEntity<CategoriaResponseDTO> salvar(@RequestBody @Valid CategoriaRequestDTO categoriaDTO){
    return ResponseEntity.status(HttpStatus.CREATED)
            .body(categoriaService.salvar(categoriaDTO));
  }

  @PutMapping("/{id}")
  public ResponseEntity<CategoriaResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid CategoriaRequestDTO categoriaDTO){
    return ResponseEntity.ok(categoriaService.atualizar(id, categoriaDTO));
  }

  @GetMapping
  public ResponseEntity<List<CategoriaResponseDTO>> listarTodas(){
    return ResponseEntity.ok(categoriaService.listarTodas());
  }

  @GetMapping("/{id}")
  public ResponseEntity<CategoriaResponseDTO> buscarPorId(@PathVariable Long id){
    return ResponseEntity.ok(categoriaService.buscarPorId(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id){
    categoriaService.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
