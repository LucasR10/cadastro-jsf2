package br.com.stefanini.jpa;

import static br.com.stefanini.util.AppUtil.imprimeCPF;
import static br.com.stefanini.util.AppUtil.isCPF;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidarCPF {

	
	private static final String CPF_VALIDO = "76926705011";

	@Test
	public void CPFValido()throws Exception {
		imprimeCPF(CPF_VALIDO);
		assertTrue( isCPF( CPF_VALIDO) );
	}
	
	
	@Test
	public void CPFCom00000000000()throws Exception {
		assertTrue( !isCPF("00000000000") );
	}
	
	@Test
	public void CPFCom55555555555()throws Exception {
		imprimeCPF("55555555555");
		assertTrue( !isCPF("55555555555") );
	}
}
