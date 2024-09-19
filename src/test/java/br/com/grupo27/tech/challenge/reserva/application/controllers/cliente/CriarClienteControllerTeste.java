package br.com.grupo27.tech.challenge.reserva.application.controllers.cliente;


import br.com.grupo27.tech.challenge.reserva.application.controllers.Cliente.CriarClienteController;
import br.com.grupo27.tech.challenge.reserva.config.TesteConfig;
import br.com.grupo27.tech.challenge.reserva.domain.presenters.cliente.ClientePresenter;
import br.com.grupo27.tech.challenge.reserva.domain.presenters.cliente.CriarClientePresenter;
import br.com.grupo27.tech.challenge.reserva.domain.useCase.cliente.ClienteUserCaseFactory;
import br.com.grupo27.tech.challenge.reserva.domain.useCase.cliente.CriarClienteUserCase;
import br.com.grupo27.tech.challenge.reserva.infra.repository.cliente.ClienteRepository;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.shaded.com.fasterxml.jackson.core.JsonProcessingException;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;


import static br.com.grupo27.tech.challenge.reserva.mock.cliente.ClienteDados.getClienteResponse;
import static br.com.grupo27.tech.challenge.reserva.mock.cliente.CriarClienteDados.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(CriarClienteController.class)
public class CriarClienteControllerTeste  extends TesteConfig {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private  CriarClientePresenter criarClientePresenter;

    @MockBean
    private ClienteUserCaseFactory clienteUserCaseFactory;

    @MockBean
    private ClientePresenter clientePresenter;

    @MockBean
    private ClienteRepository clienteRepository;

    @MockBean
    private CriarClienteUserCase criarClienteUserCase;


    void testeCriar() throws Exception {

        when(clienteUserCaseFactory.buidCriarClienteUserCase(criarClientePresenter, clientePresenter, clienteRepository))
                .thenReturn(criarClienteUserCase);

        when(criarClientePresenter.criarClienteEmClienteInput(any()))
                .thenReturn(getCriarClienteInput());

        when(criarClienteUserCase.criar(any()))
                .thenReturn(getCriarClienteOutput());

        when(criarClientePresenter.criarClienteOutputEmClienteResponse(any()))
                .thenReturn(getClienteResponse());

        mockMvc.perform(post("/clientes")
                        .contentType("application/json")
                        .content(asJsonString(getCriarClienteRequest())))
                        .andExpect(status().isOk());

        verify(criarClientePresenter,times(1)).criarClienteEmClienteInput(getCriarClienteRequest());
        verify(criarClienteUserCase, times(1)).criar(getCriarClienteInput());
        verify(criarClientePresenter,times(1)).criarClienteOutputEmClienteResponse(getCriarClienteOutput());

    }


    private static String asJsonString(final Object obj) throws JsonProcessingException {

        return new ObjectMapper().writeValueAsString(obj);
    }

}
