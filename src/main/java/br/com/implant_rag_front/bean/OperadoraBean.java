package br.com.implant_rag_front.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.implant_rag_front.dto.OperadoraDTO;
import br.com.implant_rag_front.service.OperadoraService;

@ManagedBean(name = "MBOperadora")
@ViewScoped
public class OperadoraBean {

	private OperadoraDTO operadora;

	private ArrayList<OperadoraDTO> itens;
	
	@ManagedProperty(value = "#{operadoraService}")
	private OperadoraService operadoraService;

	public OperadoraBean() {
		this.operadora = new OperadoraDTO();
	}

	public OperadoraDTO getOperadora() {
		return operadora;
	}

	public void setOperadora(OperadoraDTO operadora) {
		this.operadora = operadora;
	}

	public ArrayList<OperadoraDTO> getItens() {
		return itens;
	}

	public void setItens(ArrayList<OperadoraDTO> itens) {
		this.itens = itens;
	}
	
	public void cadastrarOperadora() {
		this.operadoraService.cadastrar(operadora);
	}
	
	public void buscarNomeBD() {
		this.operadoraService.buscarPorNome(operadora, this.operadora.getNome());
		
	}

	public void setOperadoraService(OperadoraService operadoraService) {
		this.operadoraService = operadoraService;
	}
}
