package med.voll.api.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.dtos.MedicoCreateDTO;
import med.voll.api.dtos.MedicoDTO;
import med.voll.api.dtos.MedicoUpdateDTO;
import med.voll.api.entities.Endereco;
import med.voll.api.entities.Medico;
import med.voll.api.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medico")
public class MedicoController {
  @Autowired
  private MedicoRepository repository;
  @PostMapping
  @Transactional
  public void cadastrar(@RequestBody @Valid MedicoCreateDTO dados) {
    repository.save(new Medico(dados));
  }

  @GetMapping
  public Page<MedicoDTO> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
    return repository.findAllByAtivoTrue(paginacao).map(MedicoDTO::new);
  }

  @PutMapping
  @Transactional
  public void atualizar(@RequestBody @Valid MedicoUpdateDTO dados) {
    var medico = repository.getReferenceById(dados.id());
    medico.atualizar(dados);
  }

  @DeleteMapping("/{id}")
  @Transactional
  public void excluir(@PathVariable Long id) {
    var medico = repository.getReferenceById(id);
    medico.desativar();
  }
}
