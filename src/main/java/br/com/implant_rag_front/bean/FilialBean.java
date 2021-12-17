package br.com.implant_rag_front.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;

import br.com.implant_rag_front.dto.ClienteDTO;
import br.com.implant_rag_front.dto.EstabelecimentoDTO;
import br.com.implant_rag_front.dto.FilialDTO;
import br.com.implant_rag_front.dto.UsuarioDTO;
import br.com.implant_rag_front.service.FilialService;
import br.com.implant_rag_front.util.JsfUtil;



@ManagedBean(name="MBFilial")
@ViewScoped
public class FilialBean {

	
	private FilialDTO filial;
	private ArrayList<FilialDTO> itens;
	private UsuarioDTO usuario;
	
	@ManagedProperty(value="#{filialService}")
	private FilialService filialService;
	
	private boolean carregaPainel = false;
	private boolean carregaEscolherOperadora = true;
	private boolean readOnly = false;
	private boolean requerido = true;
	private EstabelecimentoDTO estabelecimento;
	private List<EstabelecimentoDTO> estabelecimentosNaFilial;
	private ClienteDTO cliente;
	
	public FilialDTO getFilial() { return filial; }
	  
    public void setFilial(FilialDTO filial) { this.filial = filial; }
	  
	public ArrayList<FilialDTO> getItens() { return itens; }
	  
	public void setItens(ArrayList<FilialDTO> itens) { this.itens = itens;}
	
	public FilialBean() {
		
	}
	@PostConstruct
	public void init() {
		cliente = new ClienteDTO();
		Map<String, String> parametro = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        
        cliente.setCodigo(Integer.parseInt(parametro.get("idCliente")));
        cliente = filialService.buscarCliente(cliente.getCodigo());
        
        itens = new ArrayList<FilialDTO>(this.filialService.listarPorCliente(cliente.getCodigo()));
        if(cliente==null) {
        	JsfUtil.adicionarMensagemDeErro("NO FOI POSSVEL IDENTIFICAR O CLIENTE. VERIFIQUE O CODIGO E TENTE NOVAMENTE");
        	voltarParaLogin();
        }
        
	}
	public String voltarParaLogin() {
		return "login?faces-redirect=true";
	}
	public boolean isCarregaPainel() {
		return carregaPainel;
	}

	public void setCarregaPainel(boolean carregaPainel) {
		this.carregaPainel = carregaPainel;
	}
	

	public boolean isCarregaEscolherOperadora() {
		return carregaEscolherOperadora;
	}

	public void setCarregaEscolherOperadora(boolean carregaEscolherOperadora) {
		this.carregaEscolherOperadora = carregaEscolherOperadora;
	}

	public void setFilialService(FilialService filialService) {
		this.filialService = filialService;
	}
	
	public EstabelecimentoDTO getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimentoDTO(EstabelecimentoDTO estabelecimentoDTO) {
		this.estabelecimento = estabelecimentoDTO;
	}

	public UsuarioDTO getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDTO usuario) {
		this.usuario = usuario;
	}

	public ClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
	

	public boolean isRequerido() {
		return requerido;
	}

	public void setRequerido(boolean requerido) {
		this.requerido = requerido;
	}

	public List<EstabelecimentoDTO> getEstabelecimentosNaFilial() {
		return estabelecimentosNaFilial;
	}

	public void setEstabelecimentosNaFilial(List<EstabelecimentoDTO> estabelecimentosNaFilial) {
		this.estabelecimentosNaFilial = estabelecimentosNaFilial;
	}

	public void formatarCnpj() {
		String cnpj = this.filial.getCnpj();
		cnpj = cnpj.replace(".", "");
		cnpj = cnpj.replace("/", "");
		cnpj = cnpj.replace("-", "");
		this.filial.setCnpj(cnpj);
		
	}

	public void cadastrarFilial() {
		formatarCnpj();
		
		if(this.filialService.verificarCadastro(filial)) {
			this.filial.setCliente(cliente);
			this.filialService.cadastrar(filial);
			requerido = false;
			readOnly = true;
			carregaPainel = true;
			carregaEscolherOperadora = false;
		}
		else {
			JsfUtil.adicionarMensagemDeErro("Algum dos dados que voc inseriu j est presente em outra filial no nosso banco de dados."
					+ "Verifique e tente novamente.");
		}		
	}
	
	public void carregarCadastro(ComponentSystemEvent evento){
		this.filial = new FilialDTO();
		
	}
	
}
