package br.com.cast.teste.dto;

public class PessoaDTO {

	private String cpf;
	private String nome;
	private String email;
	private String endereco_cep;
	private String numero;
	private EnderecoDTO enderecodto;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEndereco_cep() {
		return endereco_cep;
	}
	public void setEndereco_cep(String endereco_cep) {
		this.endereco_cep = endereco_cep;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public EnderecoDTO getEnderecodto() {
		return enderecodto;
	}
	public void setEnderecodto(EnderecoDTO enderecodto) {
		this.enderecodto = enderecodto;
	}

	
	
	
}
