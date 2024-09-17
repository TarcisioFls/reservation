package br.com.grupo27.tech.challenge.reserva.domain.output.proprietario;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BuscarProprietarioPorIdOutput extends ProprietarioOutput {

    public BuscarProprietarioPorIdOutput(String id, String nome, String email, String senha, String telefone, String cpf) {
        super(id, nome, email, senha, telefone, cpf);
    }

}