package br.com.stefanini.service;

import java.util.List;

import br.com.stefanini.model.Pessoa;
import br.com.stefanini.repository.PessoaRepository;
import br.com.stefanini.util.AppUtil;
import br.com.stefanini.util.FacesUtil;

public class PessoaService {

	protected PessoaRepository repository = new PessoaRepository();
	
	public PessoaService() {
		 
	}
	
	public void salvar(Pessoa pessoa) {
		try {
			
			Pessoa pessoaResult = repository.buscarPorCPF( AppUtil.removerCaracterCPF(pessoa.getCpf()) );
			if(pessoaResult != null && pessoaResult.getCpf() != null  ) {
				FacesUtil.adicionarMensagemAlerta("Usuário com CPF - "+ pessoa.getCpf() +" já  cadastrado.");
				return;
			}
			String cpf = pessoa.getCpf() ;
			pessoa.setCpf( AppUtil.removerCaracterCPF( cpf ) );
			repository.salvar(pessoa);
			FacesUtil.adicionarMensagemInfo("O usuário foi cadastrado com sucesso.");
		} catch (Exception e) {
			FacesUtil.adicionarMensagemError("Não foi possível cadastrar o usuário.");
			e.printStackTrace();
		}
	}

	public List<Pessoa> listarTodos() {
		return repository.listarTodos();
	}

	public void excluir(Pessoa p) {
		 try {
				repository.excluir(p);
				FacesUtil.adicionarMensagemInfo("O usuário excluido com sucesso.");
		} catch (Exception e) {
			FacesUtil.adicionarMensagemInfo("Não foi possível cexcluir o usuário.");
			e.printStackTrace();
		}
	}
	
}
