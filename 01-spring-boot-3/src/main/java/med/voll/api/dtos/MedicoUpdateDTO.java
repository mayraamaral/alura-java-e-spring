package med.voll.api.dtos;

import jakarta.validation.constraints.NotNull;

public record MedicoUpdateDTO(
    @NotNull
    Long id,
    String nome,
    String telefone,
    EnderecoDTO enderecoDTO) {
}
