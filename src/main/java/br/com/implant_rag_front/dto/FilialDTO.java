package br.com.implant_rag_front.dto;

public class FilialDTO {
	
	private Long id;	
	
	private String razaoSocial;
	
	private String cnpj;
	
	private String apelidoLoja;
	
	private int codErp;
	
	private EstabelecimentoDTO estabelecimento;
	
	private ClienteDTO cliente;

	public FilialDTO() {
		this.cliente = new ClienteDTO();
		this.estabelecimento = new EstabelecimentoDTO();
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}


	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public String getApelidoLoja() {
		return apelidoLoja;
	}


	public void setApelidoLoja(String apelidoLoja) {
		this.apelidoLoja = apelidoLoja;
	}


	public int getCodErp() {
		return codErp;
	}


	public void setCodErp(int codErp) {
		this.codErp = codErp;
	}


	public EstabelecimentoDTO getEstabelecimento() {
		return estabelecimento;
	}


	public void setEstabelecimento(EstabelecimentoDTO estabelecimento) {
		this.estabelecimento = estabelecimento;
	}


	public ClienteDTO getCliente() {
		return cliente;
	}


	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}



	
	
	
	
	
	
}
