package br.com.grupo27.tech.challenge.reserva.domain.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND; 

@Getter
public enum CodigoError {

    PROPRIETARIO_NAO_ENCONTRADO("Proprietário não encontrado", NOT_FOUND, FALSE),
    TELEFONE_OBRIGATORIO("Telefone é obrigatório", BAD_REQUEST, FALSE),
    CPF_OBRIGATORIO("CPF é obrigatório", BAD_REQUEST, FALSE),
    CPF_JA_CADASTRADO("CPF já cadastrado", BAD_REQUEST, FALSE),
    SENHA_OBRIGATORIO("Senha é obrigatória", BAD_REQUEST, FALSE),
    NOME_OBRIGATORIO("Nome é obrigatório", BAD_REQUEST, FALSE),
    EMAIL_OBRIGATORIO("Email é obrigatório", BAD_REQUEST, FALSE),
    EMAIL_JA_CADASTRADO("Email já cadastrado", BAD_REQUEST, FALSE),
    PROPRIETARIO_JA_CADASTRADO("Proprietário já cadastrado", BAD_REQUEST, FALSE),
    NOME_CLIENTE_VALIDO("O campo nome deve ser preenchido com o nome e sobrenome", BAD_REQUEST, FALSE),
    CLIENTE_NAO_ENCONTRADO("Cliente não encontrado", NOT_FOUND, FALSE),

    ERRO_DESCONHECIDO("Erro desconhecido", INTERNAL_SERVER_ERROR, TRUE),
    DESCRICAO_OBRIGATORIA("Descrição é obrigatória", BAD_REQUEST,FALSE),
    LOCALIZACAO_OBRIGATORIA("Localização é obrigatória", BAD_REQUEST, FALSE),
    CAPACIDADE_INVALIDA("Capacidade precisa ser maior que 0", BAD_REQUEST, FALSE),
    TIPO_COZINHA_OBRIGATORIA("Tipo de Cozinha é obrigatório",BAD_REQUEST, FALSE),
    PROPRIETARIO_OBRIGATORIO("Proprietário é obrigatório", BAD_REQUEST, FALSE),
    HORARIO_FUNCIONAMENTO_OBRIGATORIO("Horário de Funcionamento é obrigatório", BAD_REQUEST, FALSE),
    RESTAURANTE_NAO_ENCONTRADO("Restaurante não encontrado", NOT_FOUND, FALSE),
    HORARIO_FUNCIONAMENTO_INVALIDO("Horário de Funcionamento inválido", BAD_REQUEST, FALSE),
    HORA_ABERTURA_RESTAURANTE_MAIOR_HORA_FECHAMENTO("Hora de abertura do restaurante não pode ser maior que a hora de fechamento", BAD_REQUEST, FALSE),

    AVALIACAO_INVALIDA("A nota da Avaliação só é permitido valores entre 0 e 5", BAD_REQUEST, FALSE),
    AVALIACAO_OBRIGATORIA("A nota para a Avaliação é obrigatória", BAD_REQUEST, FALSE);

    private final String mensagem;
    private final HttpStatus httpStatus;
    private final int codigo;
    private final boolean exibirDescricaoError;

    CodigoError(String mensagem, HttpStatus httpStatus, boolean exibirDescricaoError) {
        this.mensagem = mensagem;
        this.httpStatus = httpStatus;
        this.codigo = httpStatus.value();
        this.exibirDescricaoError = exibirDescricaoError;
    }

}
