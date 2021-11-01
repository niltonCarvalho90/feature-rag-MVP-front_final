package br.com.implant_rag_front.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.implant_rag_front.dto.ClienteDTO;

@ManagedBean(name="MBCliente")
@ViewScoped
public class ClienteBean {

	
	private ClienteDTO cliente;
	private ArrayList<ClienteDTO> itens;


	private ClienteBean() {
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
	
	


}
