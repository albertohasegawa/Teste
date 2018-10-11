package br.com.cast.teste.interfac;

import java.util.List;

import br.com.cast.teste.dto.PessoaDTO;

public interface InterfacePessoaServices {

	public List<PessoaDTO> buscarTodos();
	public PessoaDTO buscarPorCpf(String cpf);
	public void deletar(String cpf);
	public void salvar(PessoaDTO pessoaDTO);
}
