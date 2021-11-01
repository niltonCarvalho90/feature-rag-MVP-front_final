package br.com.implant_rag_front.dto;

public class EstabelecimentoDTO {

	
	private Long id;
	
	
	private OperadoraDTO operadora;
	
	private FilialDTO filial;
	
	
	private String codFilialOperadora;

	public EstabelecimentoDTO() {
		this.filial = new FilialDTO();
		this.operadora = new OperadoraDTO();
		
	}
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public OperadoraDTO getOperadora() {
		return operadora;
	}


	public void setOperadora(OperadoraDTO operadora) {
		this.operadora = operadora;
	}


	public FilialDTO getFilial() {
		return filial;
	}


	public void setFilial(FilialDTO filial) {
		this.filial = filial;
	}


	public String getCodFilialOperadora() {
		return codFilialOperadora;
	}


	public void setCodFilialOperadora(String codFilialOperadora) {
		this.codFilialOperadora = codFilialOperadora;
	}


	
	
	
	
}
