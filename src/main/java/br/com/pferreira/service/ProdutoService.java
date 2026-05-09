package br.com.pferreira.service;

import br.com.pferreira.domain.Categoria;
import br.com.pferreira.domain.Produto;
import br.com.pferreira.dto.CategoriaResponseDTO;
import br.com.pferreira.dto.ProdutoRequestDTO;
import br.com.pferreira.dto.ProdutoResponseDTO;
import br.com.pferreira.exception.ResourceNotFoundException;
import br.com.pferreira.repository.CategoriaRepository;
import br.com.pferreira.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pedro Ferreira
 */

@Service
@RequiredArgsConstructor
public class ProdutoService {

  private final ProdutoRepository produtoRepository;
  private final CategoriaRepository categoriaRepository;

  public ProdutoResponseDTO salvar(ProdutoRequestDTO produtoDTO){
    Categoria categoria = categoriaRepository.findById(produtoDTO.getCategoriaId())
            .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

    Produto produto = new Produto();
    produto.setCategoria(categoria);
    produto.setNome(produtoDTO.getNome());
    produto.setDisponivel(produtoDTO.getDisponivel());
    produto.setPreco(produtoDTO.getPreco());
    produto.setImagemUrl(produtoDTO.getImagemUrl());
    produto.setDescricao(produtoDTO.getDescricao());

    return toResponse(produtoRepository.save(produto));
  }

  public ProdutoResponseDTO atualizar(Long id, ProdutoRequestDTO produtoAtualizadoDTO){
    Produto produto = findById(id);

    Categoria categoria = categoriaRepository.findById(produtoAtualizadoDTO.getCategoriaId())
                    .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

    produto.setNome(produtoAtualizadoDTO.getNome());
    produto.setDescricao(produtoAtualizadoDTO.getDescricao());
    produto.setPreco(produtoAtualizadoDTO.getPreco());
    produto.setDisponivel(produtoAtualizadoDTO.getDisponivel());
    produto.setImagemUrl(produtoAtualizadoDTO.getImagemUrl());
    produto.setCategoria(categoria);
    return toResponse(produtoRepository.save(produto));
  }

  public List<ProdutoResponseDTO> listarTodos(){
    return produtoRepository.findAll()
            .stream()
            .map(this::toResponse)
            .toList();
  }

  public ProdutoResponseDTO buscarPorId(Long id){
    return toResponse(findById(id));
  }

  public void deletar(Long id){
    produtoRepository.deleteById(id);
  }

  private Produto findById(Long id){
    return produtoRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));
  }

  private ProdutoResponseDTO toResponse(Produto produto){
    return new ProdutoResponseDTO(
            produto.getId(),
            produto.getNome(),
            produto.getDescricao(),
            produto.getPreco(),
            produto.getImagemUrl(),
            produto.getDisponivel(),
            produto.getCategoria().getNome()
    );
  }
}
