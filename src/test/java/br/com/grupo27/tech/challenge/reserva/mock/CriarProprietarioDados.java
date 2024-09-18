package br.com.grupo27.tech.challenge.reserva.mock;

import br.com.grupo27.tech.challenge.reserva.application.controllers.proprietario.request.CriarProprietarioRequest;
import br.com.grupo27.tech.challenge.reserva.application.controllers.proprietario.response.ProprietarioResponse;
import br.com.grupo27.tech.challenge.reserva.domain.entity.Proprietario;
import br.com.grupo27.tech.challenge.reserva.domain.input.proprietario.CriarProprietarioInput;
import br.com.grupo27.tech.challenge.reserva.domain.output.proprietario.CriarProprietarioOutput;

public interface CriarProprietarioDados {

    static ProprietarioResponse getProprieatarioResponse() {
        return new ProprietarioResponse("66c67aa035ed1f735450b7a2", "João", "joao@teste.com", "123456", "11999999999", "11999999999");
    }

    static CriarProprietarioRequest getCriarProprietarioRequest() {
        return new CriarProprietarioRequest("João", "joao@teste.com", "123456", "11999999999", "11999999999");
    }

    static CriarProprietarioRequest getCriarProprietarioRequestComNomeEmBranco() {
        var criarProprietarioRequest = getCriarProprietarioRequest();
        criarProprietarioRequest.setNome("");
        return criarProprietarioRequest;
    }

    static CriarProprietarioRequest getCriarProprietarioRequestComNomeNull() {
        var criarProprietarioRequest = getCriarProprietarioRequest();
        criarProprietarioRequest.setNome(null);
        return criarProprietarioRequest;
    }

    static CriarProprietarioRequest getCriarProprietarioRequestComEmailEmBranco() {
        var criarProprietarioRequest = getCriarProprietarioRequest();
        criarProprietarioRequest.setEmail("");
        return criarProprietarioRequest;
    }

    static CriarProprietarioRequest getCriarProprietarioRequestComEmailNull() {
        var criarProprietarioRequest = getCriarProprietarioRequest();
        criarProprietarioRequest.setEmail(null);
        return criarProprietarioRequest;
    }

    static CriarProprietarioRequest getCriarProprietarioRequestComPasswordEmBranco() {
        var criarProprietarioRequest = getCriarProprietarioRequest();
        criarProprietarioRequest.setSenha("");
        return criarProprietarioRequest;
    }

    static CriarProprietarioRequest getCriarProprietarioRequestComPasswordNull() {
        var criarProprietarioRequest = getCriarProprietarioRequest();
        criarProprietarioRequest.setSenha(null);
        return criarProprietarioRequest;
    }

    static CriarProprietarioRequest getCriarProprietarioRequestComTelefoneEmBranco() {
        var criarProprietarioRequest = getCriarProprietarioRequest();
        criarProprietarioRequest.setTelefone("");
        return criarProprietarioRequest;
    }

    static CriarProprietarioRequest getCriarProprietarioRequestComTelefoneNull() {
        var criarProprietarioRequest = getCriarProprietarioRequest();
        criarProprietarioRequest.setTelefone(null);
        return criarProprietarioRequest;
    }

    static CriarProprietarioRequest getCriarProprietarioRequestComCpfEmBranco() {
        var criarProprietarioRequest = getCriarProprietarioRequest();
        criarProprietarioRequest.setCpf("");
        return criarProprietarioRequest;
    }

    static CriarProprietarioRequest getCriarProprietarioRequestComCpfNull() {
        var criarProprietarioRequest = getCriarProprietarioRequest();
        criarProprietarioRequest.setCpf(null);
        return criarProprietarioRequest;
    }

    static CriarProprietarioOutput getCriarProprietarioOutput() {
        return new CriarProprietarioOutput("66c67aa035ed1f735450b7a2", "João", "joao@teste.com", "123456", "11999999999", "11999999999");
    }

    static Proprietario getProprietario() {
        return new Proprietario(null, "João", "joao@teste.com", "123456", "11999999999", "11999999999");
    }

    static Proprietario getProprietarioDepoisDeSalvar() {
        var proprietario = getProprietario();
        proprietario.setId("66c67aa035ed1f735450b7a2");
        return proprietario;
    }

    static CriarProprietarioInput getCriarProprietarioInput() {
        return new CriarProprietarioInput(null, "João", "joao@teste.com", "123456", "11999999999", "11999999999");
    }

}