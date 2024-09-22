package br.com.grupo27.tech.challenge.reserva.domain.output.avaliacao;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ListarTodosAvaliacaoOutput extends AvaliacaoOutput {

    public ListarTodosAvaliacaoOutput(String id, Integer nota, String comentario, String reservaId) {
        super(id, nota, comentario, reservaId);
    }
}