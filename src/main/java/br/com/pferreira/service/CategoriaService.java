package br.com.pferreira.service;

import br.com.pferreira.domain.Categoria;
import br.com.pferreira.dto.CategoriaRequestDTO;
import br.com.pferreira.dto.CategoriaResponseDTO;
import br.com.pferreira.exception.ResourceNotFoundException;
import br.com.pferreira.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pedro Ferreira
 */

@Service
@RequiredArgsConstructor
public class CategoriaService {

  private final CategoriaRepository categoriaRepository;

  public CategoriaResponseDTO salvar(CategoriaRequestDTO requestDTO){
    Categoria categoria = new Categoria();
    categoria.setDescricao(requestDTO.getDescricao());
    categoria.setNome(requestDTO.getNome());
    Categoria salva = categoriaRepository.save(categoria);
    return toResponse(salva);

  }

  public CategoriaResponseDTO atualizar(Long id, CategoriaRequestDTO categoriaAtualizadaDTO){
    Categoria categoria = findById(id);
    categoria.setNome(categoriaAtualizadaDTO.getNome());
    categoria.setDescricao(categoriaAtualizadaDTO.getDescricao());
    return toResponse(categoriaRepository.save(categoria));
  }

  public List<CategoriaResponseDTO> listarTodas(){
    return categoriaRepository.findAll()
            .stream()
            .map(this::toResponse)
            .toList();
  }

  public CategoriaResponseDTO buscarPorId(Long id){
    return toResponse(findById(id));
  }

  public void deletar(Long id){
    categoriaRepository.deleteById(id);
  }

  private Categoria findById(Long id){
    return categoriaRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));
  }

  private CategoriaResponseDTO toResponse(Categoria categoria){
    return new CategoriaResponseDTO(
            categoria.getId(),
            categoria.getNome(),
            categoria.getDescricao()
    );
  }
}
