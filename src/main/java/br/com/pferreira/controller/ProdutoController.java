package br.com.pferreira.controller;

import br.com.pferreira.domain.Produto;
import br.com.pferreira.dto.ProdutoRequestDTO;
import br.com.pferreira.dto.ProdutoResponseDTO;
import br.com.pferreira.service.ProdutoService;
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
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutoController {

  private final ProdutoService produtoService;

  @PostMapping
  public ResponseEntity<ProdutoResponseDTO> salvar(@RequestBody @Valid ProdutoRequestDTO produtoDTO){
    return ResponseEntity.status(HttpStatus.CREATED).
            body(produtoService.salvar(produtoDTO));
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProdutoResponseDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoRequestDTO produtoDTO){
    return ResponseEntity.ok(produtoService.atualizar(id, produtoDTO));
  }

  @GetMapping
  public ResponseEntity<List<ProdutoResponseDTO>> listarTodos(){
    return ResponseEntity.ok(produtoService.listarTodos());
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProdutoResponseDTO> buscarPorId(@PathVariable Long id){
    return ResponseEntity.ok(produtoService.buscarPorId(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id){
    produtoService.deletar(id);
    return ResponseEntity.noContent().build();
  }
}
