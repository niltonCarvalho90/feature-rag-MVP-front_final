package br.com.implant_rag_front.bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.implant_rag_front.dto.EstabelecimentoDTO;

@ManagedBean(name="MBEstabelecimento")
@ViewScoped
public class EstabelecimentoBean {

	private EstabelecimentoDTO estabelecimento;
	private ArrayList<EstabelecimentoDTO> itens;
	
	public EstabelecimentoBean() {
		this.estabelecimento = new EstabelecimentoDTO();
	}
	public EstabelecimentoDTO getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(EstabelecimentoDTO estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	public ArrayList<EstabelecimentoDTO> getItens() {
		return itens;
	}
	public void setItens(ArrayList<EstabelecimentoDTO> itens) {
		this.itens = itens;
	}

	
}
