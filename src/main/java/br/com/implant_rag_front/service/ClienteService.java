package br.com.implant_rag_front.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.implant_rag_front.client.ClienteClient;
import br.com.implant_rag_front.dto.ClienteDTO;
@Service
public class ClienteService {

    @Autowired
    private ClienteClient clienteClient;




    public ClienteService(ClienteClient clienteClient) {
        this.clienteClient = clienteClient;
    }

    public ClienteService() {

    }


    public ClienteClient getClienteClient() {
        return clienteClient;
    }




    public void setClienteClient(ClienteClient clienteClient) {
        this.clienteClient = clienteClient;
    }


    public void deletarCliente(Integer codigo) {
        clienteClient.deletarCliente(codigo);
    }

    public List<ClienteDTO> listarClientes(){
        return clienteClient.listarUsuarios();
    }

    public void editar(ClienteDTO cliente) {
    	 this.clienteClient.editar(cliente);
    }
    public Integer cadastrarCliente(ClienteDTO cliente, String nome) {
        return this.clienteClient.cadastrarUsuarios(cliente, nome);
    }
}
