package br.com.stefanini.service;

import java.util.Calendar;
import java.util.List;

import br.com.stefanini.model.Pessoa;
import br.com.stefanini.repository.PessoaRepository;
import br.com.stefanini.util.AppUtil;
import br.com.stefanini.util.FacesUtil;

/**
 * @author Lucas Carvalho
 * @since 17/15/2020
 * */
public class PessoaService {

	protected PessoaRepository repository = new PessoaRepository();
	
	public PessoaService() {
		 
	}
	
	public String salvar(Pessoa pessoa) {
		try {
			if( null != pessoa.getCpf() ) {
				pessoa.setCpf( removerCaracterCPF( pessoa.getCpf() ) );
				Pessoa pessoaResult = repository.buscarPorCPF( pessoa.getCpf() );
				if( pessoaResult != null ) {
					 pessoa.setDataUtimaAtualizacao( Calendar.getInstance() );
					 pessoa.setId( pessoaResult.getId() );
					 repository.atualizar(pessoa);
					 FacesUtil.adicionarMensagemAlerta("Usuário atualizados com sucesso. CPF - "+ pessoa.getCpf() +" já  cadastrado.");
					return "/view/cadastroPessoa.xhtml";
				}
				pessoa.setDataCadastro( Calendar.getInstance() );
				repository.salvar(pessoa);
				FacesUtil.adicionarMensagemInfo("O usuário foi cadastrado com sucesso.");
		  }
			return "/view/cadastroPessoa.xhtml?faces-redirect=true";
		} catch (Exception e) {
			FacesUtil.adicionarMensagemError("Não foi possível cadastrar o usuário.");
			e.printStackTrace();
			return null;
		}
	}

	private String removerCaracterCPF(String cpf) {
		return AppUtil.removerCaracterCPF( cpf );
	}

	public List<Pessoa> listarTodos() {
		return repository.listarTodos();
	}

	public void excluir(Pessoa p) {
		 try {
			repository.excluir(p);
			FacesUtil.adicionarMensagemInfo("O usuário excluido com sucesso.");
		} catch (Exception e) {
			FacesUtil.adicionarMensagemError("Não foi possível cexcluir o usuário.");
			e.printStackTrace();
		}
	}
	
}
