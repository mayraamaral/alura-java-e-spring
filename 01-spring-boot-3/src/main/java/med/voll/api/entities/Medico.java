package med.voll.api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.dtos.MedicoCreateDTO;
import med.voll.api.dtos.MedicoUpdateDTO;
import med.voll.api.enums.Especialidade;

@Table(name = "medico")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String nome;
  private String email;
  private String telefone;
  private String crm;

  @Enumerated(EnumType.STRING)
  private Especialidade especialidade;

  @Embedded
  private Endereco endereco;
  private Boolean ativo;

  public Medico(MedicoCreateDTO medico) {
    this.ativo = true;
    this.nome = medico.nome();
    this.email = medico.email();
    this.telefone = medico.telefone();
    this.crm = medico.crm();
    this.especialidade = medico.especialidade();
    this.endereco = new Endereco(medico.endereco());
  }

  public void atualizar(MedicoUpdateDTO medico) {
    if(medico.nome() != null) {
      this.nome = medico.nome();
    }
    if(medico.telefone() != null) {
      this.telefone = medico.telefone();
    }
    if(medico.enderecoDTO() != null) {
      this.endereco.atualizar(medico.enderecoDTO());

    }
  }

  public void desativar() {
    this.ativo = false;
  }
}
