package br.com.implant_rag_front.bean;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import br.com.implant_rag_front.dto.EstabelecimentoDTO;
import br.com.implant_rag_front.dto.FilialDTO;
import br.com.implant_rag_front.dto.OperadoraDTO;
import br.com.implant_rag_front.service.EstabelecimentoService;
import br.com.implant_rag_front.util.JsfUtil;



@ManagedBean(name="MBEstabelecimento")
@ViewScoped
public class EstabelecimentoBean {
	
	private boolean carregaOperadoras = false;
	private boolean carregaValidaDados = false;
	private boolean desabilitaBotao = false;

	private EstabelecimentoDTO estabelecimento;
	private ArrayList<EstabelecimentoDTO> itens;
	private ArrayList<OperadoraDTO> itensSelecionados;
	private ArrayList<EstabelecimentoDTO> estabelecimentosNaFilial;
	private FilialDTO filial = new FilialDTO();
	
	@ManagedProperty(value="#{estabelecimentoService}")
	private EstabelecimentoService estabelecimentoService;
	

	@PostConstruct
    public void init() {
        this.itens = new ArrayList<EstabelecimentoDTO>();
        //estabelecimentosNaFilial = new ArrayList<EstabelecimentoDTO>(this.estabelecimentoService.estabelecimentosNaFilial(this.filial));
    }
	public EstabelecimentoBean() {

	}

	public FilialDTO getFilial() {
		return filial;
	}
	public void setFilial(FilialDTO filial) {
		this.filial = filial;
	}
	public void setEstabelecimentoService(EstabelecimentoService estabelecimentoService) {
		this.estabelecimentoService = estabelecimentoService;
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
	
	public boolean getCarregaOperadoras() {
		return carregaOperadoras;
	}
	
	public boolean isCarregaValidaDados() {
		return carregaValidaDados;
	}
	public void setCarregaValidaDados(boolean carregaValidaDados) {
		this.carregaValidaDados = carregaValidaDados;
	}
	public void setCarregaOperadoras(boolean carregaOperadoras) {
		this.carregaOperadoras = carregaOperadoras;
	}
	
	public ArrayList<OperadoraDTO> getItensSelecionados() {
		return itensSelecionados;
	}

	public void setItensSelecionados(ArrayList<OperadoraDTO> itensSelecionados) {
		this.itensSelecionados = itensSelecionados;
	}

	public boolean isDesabilitaBotao() {
		return desabilitaBotao;
	}

	public void setDesabilitaBotao(boolean desabilitaBotao) {
		this.desabilitaBotao = desabilitaBotao;
	}
	
	public ArrayList<EstabelecimentoDTO> getEstabelecimentosNaFilial() {
		return estabelecimentosNaFilial;
	}
	public void setEstabelecimentosNaFilial(ArrayList<EstabelecimentoDTO> estabelecimentosNaFilial) {
		this.estabelecimentosNaFilial = estabelecimentosNaFilial;
	}
	public void buscaFilial() {
		
		
	}
	
	public void escolher() {
		carregaOperadoras = true;
		carregaValidaDados = true;
		desabilitaBotao = true;
		this.filial = this.estabelecimentoService.buscaFilial();
		
		for (OperadoraDTO operadora : itensSelecionados) {
			this.estabelecimento = new EstabelecimentoDTO();
			this.estabelecimento.setOperadora(operadora);
			this.estabelecimento.setFilial(this.filial);
			this.itens.add(this.estabelecimento);
		}
		JsfUtil.adicionarMensagemDeSucesso("Operadoras escolhidas com sucesso!");

	}
	public void cadastrar() {
		for (EstabelecimentoDTO estabelecimento : itens) {
			
			this.estabelecimentoService.cadastrar(estabelecimento);
		}
		JsfUtil.adicionarMensagemDeSucesso("Códigos inseridos com sucesso!");
	}
	
	
}
