package br.com.grupo27.tech.challenge.reserva.domain.useCase.cliente;


import br.com.grupo27.tech.challenge.reserva.domain.presenters.cliente.*;
import br.com.grupo27.tech.challenge.reserva.infra.adapter.cliente.AtualizarClienteAdapter;
import br.com.grupo27.tech.challenge.reserva.infra.adapter.cliente.BuscarClientePorIdAdapter;
import br.com.grupo27.tech.challenge.reserva.infra.adapter.cliente.CriarClienteAdapter;
import br.com.grupo27.tech.challenge.reserva.infra.adapter.cliente.ListarTodosClientesAdapter;
import br.com.grupo27.tech.challenge.reserva.infra.repository.cliente.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClienteUserCaseFactory {


    public CriarClienteUserCase buidCriarClienteUserCase( CriarClientePresenter criarClientePresenter,
                                                                  ClientePresenter clientePresenter,
                                                                  ClienteRepository clienteRepository)
    {
        return  new CriarClienteUserCase(
                buildCriarClienteGateway(clientePresenter, clienteRepository), criarClientePresenter);

    }


    private CriarClienteAdapter buildCriarClienteGateway(ClientePresenter clientePresenter, ClienteRepository clienteRepository){
        return new CriarClienteAdapter(clienteRepository, clientePresenter);
    }

    public AtualizarClienteUserCase buidAtualizarClienteUserCase( AtualizarClientePresenter atualizarClientePresenter,
                                                                  ClientePresenter clientePresenter,
                                                                  ClienteRepository clienteRepository)
    {
        return  new AtualizarClienteUserCase(
                buildAtualizarClienteGateway(clientePresenter, clienteRepository), atualizarClientePresenter);

    }

    private AtualizarClienteAdapter buildAtualizarClienteGateway(ClientePresenter clientePresenter, ClienteRepository clienteRepository){
        return new AtualizarClienteAdapter(clienteRepository, clientePresenter);
    }

    public ListarTodosClientesUserCase buildListarTodosClientesUserCase(ListarTodosClientesPresenter listarTodosClientesPresenter,
                                                                         ClientePresenter clientePresenter,
                                                                         ClienteRepository clienteRepository){
        return new ListarTodosClientesUserCase(buildListarTodosClientesGateway(clientePresenter, clienteRepository), listarTodosClientesPresenter);
    }

    private ListarTodosClientesAdapter buildListarTodosClientesGateway(ClientePresenter clientePresenter,
                                                                       ClienteRepository clienteRepository
                                                                       ){
        return  new ListarTodosClientesAdapter(clienteRepository, clientePresenter);
    }

    public BuscarClientePorIdUserCase buildBuscarClientePorIdUserCase(BuscarClientePorIdPresenter buscarClientePorIdPresenter,
                                                                       ClientePresenter clientePresenter,
                                                                       ClienteRepository clienteRepository){

        return new BuscarClientePorIdUserCase(
                buildBuscarClientePorIdGateway(clientePresenter, clienteRepository),
                buscarClientePorIdPresenter
        );
    }

    private BuscarClientePorIdAdapter buildBuscarClientePorIdGateway(ClientePresenter clientePresenter,
                                                                     ClienteRepository clienteRepository){

        return new BuscarClientePorIdAdapter(clienteRepository, clientePresenter);
    }
}
