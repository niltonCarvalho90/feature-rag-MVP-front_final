package br.com.implant_rag_front.responseDTO;

import java.util.List;
import org.springframework.http.HttpStatus;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.com.implant_rag_front.dto.OperadoraDTO;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OperadoraResponse {
	private HttpStatus status;
	private List<OperadoraDTO> operadoras;
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public List<OperadoraDTO> getOperadoras() {
		return operadoras;
	}
	public void setOperadoras(List<OperadoraDTO> operadoras) {
		this.operadoras = operadoras;
	}
	
}
