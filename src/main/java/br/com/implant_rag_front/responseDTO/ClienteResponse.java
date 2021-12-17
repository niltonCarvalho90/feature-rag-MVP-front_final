package br.com.implant_rag_front.responseDTO;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.implant_rag_front.dto.ClienteDTO;
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClienteResponse {

	private HttpStatus status;
	private List<ClienteDTO> clientes;
	
	
	public List<ClienteDTO> getClientes() {
		return clientes;
	}
	public void setClientes(List<ClienteDTO> clientes) {
		this.clientes = clientes;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	
	
}
