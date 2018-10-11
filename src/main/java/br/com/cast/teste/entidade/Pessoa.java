package br.com.cast.teste.entidade;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.cast.teste.dto.PessoaDTO;

@Entity
@Table(schema="manterpessoa", name="pessoa")
public class Pessoa {

	@Id
	String cpf;
	String nome;
	String email;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name = "endereco")
	Endereco endereco; 
	
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public static void fromDTO(Pessoa pessoa, PessoaDTO pessoaDTO) {
		Endereco endereco = new Endereco();
		Endereco.fromDTO(endereco, pessoaDTO.getEnderecodto());
		pessoa.setCpf(pessoaDTO.getCpf());
		pessoa.setEmail(pessoaDTO.getEmail());
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setEndereco(endereco);
	}
	
}
