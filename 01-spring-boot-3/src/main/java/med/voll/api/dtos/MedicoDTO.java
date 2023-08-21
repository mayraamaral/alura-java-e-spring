package med.voll.api.dtos;

import med.voll.api.entities.Medico;
import med.voll.api.enums.Especialidade;

public record MedicoDTO(Long id, String nome, String email, String crm, Especialidade especialidade) {
  public MedicoDTO(Medico medico) {
    this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
  }
}
