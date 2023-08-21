package med.voll.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EnderecoDTO(
    @NotBlank
    String logradouro,
    @NotBlank
    String bairro,
    @NotBlank
    @Size()
    String cep,
    @NotBlank
    String cidade,
    @NotBlank
    String uf,
    String complemento,
    String numero) {
}
