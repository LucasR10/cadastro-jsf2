package br.com.stefanini.ws;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.stefanini.dto.EstadoDTO;

class BuscarEstadosTeste {

	@Test
	void buscar_estados_json() {
		assertTrue(EstadoClient.buscarEstadosJon().contains("DF") );
		
	}
	
	@Test
	void conveter_estados_json_to_dto() {
		List<EstadoDTO> estdos = EstadoClient.converterJsonToEstadoDTO( EstadoClient.buscarEstadosJon() );
		assertTrue( estdos != null && !estdos.isEmpty() && estdos.get(0) instanceof EstadoDTO );
	}

}
