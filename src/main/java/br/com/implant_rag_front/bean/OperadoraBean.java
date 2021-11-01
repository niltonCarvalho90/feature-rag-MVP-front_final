package br.com.implant_rag_front.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.implant_rag_front.dto.OperadoraDTO;

@ManagedBean(name = "MBOperadora")
@ViewScoped
public class OperadoraBean {

	private OperadoraDTO operadora;

	private ArrayList<OperadoraDTO> itens;

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
		
	}

}
