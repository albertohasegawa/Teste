package br.com.cast.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.cast.teste.dto.PessoaDTO;
import br.com.cast.teste.services.PessoaServices;

@Controller
@RequestMapping(path="/pessoas")
public class PessoaController {

	@Autowired
	private PessoaServices pServ;
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET)
	public List<PessoaDTO>  buscarPessoas() {
		List<PessoaDTO> pessoas = (List<PessoaDTO>) pServ.buscarTodos();
		return pessoas;
	}
	
	@ResponseBody
	@RequestMapping(path="{cpf}", method=RequestMethod.GET)
	public PessoaDTO  buscarPessoaPorCpf(@PathVariable("cpf") String cpf) {
		PessoaDTO pdto =  pServ.buscarPorCpf(cpf);
		return pdto;
	}
	
	@RequestMapping(path="{cpf}", method=RequestMethod.DELETE)
	@ResponseBody
	public String deletar(@PathVariable("cpf") String cpf) {
		pServ.deletar(cpf);
		return cpf;
		
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes={"application/json"}) 
	@ResponseBody
	public String salvar(@RequestBody PessoaDTO json) {
		
		pServ.salvar(json);
		return json.getNome();
	}
	
    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
