package br.com.implant_rag_front.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.implant_rag_front.dto.FilialDTO;

@ManagedBean(name="MBFilial")
@ViewScoped
public class FilialBean {

	
	private FilialDTO filial;

	private ArrayList<FilialDTO> itens;
	
	
	public FilialBean() {
		this.filial = new FilialDTO();
		
	}

	public FilialDTO getFilial() {
		return filial;
	}

	public void setFilial(FilialDTO filial) {
		this.filial = filial;
	}

	public ArrayList<FilialDTO> getItens() {
		return itens;
	}

	public void setItens(ArrayList<FilialDTO> itens) {
		this.itens = itens;
	}
	
	
}
