package br.com.stefanini.login;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.stefanini.model.Usuario;
import br.com.stefanini.repository.UsuarioRepository;

public class LoginTeste {

	private static UsuarioRepository usuarioRepository = new UsuarioRepository();
	
	
	@Test
	void buscarUsuarioAdmin() throws Exception {
        String senha = "12345";
		String login = "admin";
		usuarioRepository.salvar(new Usuario("Pedro Paulo", login, senha, Boolean.TRUE) );
		Usuario u = usuarioRepository.buscar(login, senha);
		System.out.println(u);
		Assert.assertEquals("Pedro Paulo", u.getNome() );
	}
	
	@Test
	void buscarUsuario() throws Exception {
	    String login = "neymarjr";
		String senha = "12345";
		usuarioRepository.salvar(new Usuario("Neymar jr", login, senha, Boolean.FALSE));
		Usuario u = usuarioRepository.buscar( login, senha );
		System.out.println(u);
		Assert.assertEquals("Neymar jr", u.getNome() );
	}
}
