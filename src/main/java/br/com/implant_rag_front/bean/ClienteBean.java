package br.com.implant_rag_front.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.implant_rag_front.dto.ClienteDTO;
import br.com.implant_rag_front.service.ClienteService;
import br.com.implant_rag_front.util.JsfUtil;

@ManagedBean(name="MBCliente")
@ViewScoped
public class ClienteBean {

    
    private ClienteDTO cliente;
    private ArrayList<ClienteDTO> itens;
    
    @ManagedProperty(value = "#{clienteService}")
    private ClienteService clienteService;

    public ClienteBean() {
        this.cliente = new ClienteDTO();
    }
    
    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public ArrayList<ClienteDTO> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ClienteDTO> itens) {
        this.itens = itens;
    }
    
    
    public ClienteService getClienteService() {
        return clienteService;
    }

    public void setClienteService(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    @PostConstruct
    public void listarClientes() {
        itens = new ArrayList<ClienteDTO>(clienteService.listarClientes());
        
    }
    
    public List<ClienteDTO> listarCliente() {
        return itens = new ArrayList<ClienteDTO>(clienteService.listarClientes());
        
    }
    public void cadastrarCliente() {
        
        Boolean validadorNome = true;
        
        
        System.out.println(this.cliente.getNomeEmpresa());
        if(this.cliente.getNomeEmpresa().equals(" ")) {
                validadorNome = false;
                JsfUtil.adicionarMensagemDeErro("Nome inválido", null);
        }else {
            validadorNome = true;
        }
        
        if(validadorNome == true) {
            
            Random     n1 = new Random();
            
            this.cliente.setCodigo(n1.nextInt(1000000000));

            
            Integer conferirCadastro = this.clienteService.cadastrarCliente(this.cliente, this.cliente.getNomeEmpresa());
            this.cliente.setNomeEmpresa(null);
            listarClientes();

            if(conferirCadastro == 0) {
                JsfUtil.adicionarMensagemDeSucesso("Cliente cadastrado com sucesso", null);
            }else if(conferirCadastro == 1) {
                JsfUtil.adicionarMensagemDeErro("Cliente já cadastrado", null);
            }
        }
        
    }
    
    public void deletarCliente() {

        clienteService.deletarCliente(this.cliente.getCodigo());
        List<ClienteDTO> clientes = listarCliente();
        String nomeCliente = null;
        Boolean validador = true;

        for(ClienteDTO cliente : clientes) {

            nomeCliente  = cliente.getNomeEmpresa();


           
        }
        if(nomeCliente.equals(cliente.getNomeEmpresa())) {

            JsfUtil.adicionarMensagemDeErro("Esse cliente não pode ser deletado, pois há usuários conectados", null);
            validador = false;
        }

        if(validador == true) {
            JsfUtil.adicionarMensagemDeSucesso("Cliente deletado com sucesso", null);

        }

        this.cliente.setNomeEmpresa(null);

    }
    public void editar() {
            
        this.cliente.setCodigo(this.cliente.getCodigo());
        this.clienteService.editar(this.cliente);
        listarClientes();

        if(this.cliente.getStatus() == true) {
            JsfUtil.adicionarMensagemDeSucesso(this.cliente.getNomeEmpresa() + "Está ativo", null);
        }else if(this.cliente.getStatus() == false) {
            JsfUtil.adicionarMensagemDeAtencao(this.cliente.getNomeEmpresa() + "Está inativo", null);
        }
        this.cliente.setNomeEmpresa(null);
    }
        
 
    
}
