package br.com.stefanini.ws;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientHandlerException;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;

import br.com.stefanini.dto.EstadoDTO;

public class EstadoClient {
	
	private static final String BUSCAR_ESTADOS = "https://servicodados.ibge.gov.br/api/v1/localidades/estados";
	
	public static  String  buscarEstadosJon() {
		try {
			Client c = Client.create();
			WebResource resource = c.resource(BUSCAR_ESTADOS);
			return  resource.get(String.class);
		} catch (UniformInterfaceException e) {
			System.out.println("Formato Invalido :" + BUSCAR_ESTADOS );
			e.printStackTrace();
		} catch (ClientHandlerException e) {
			System.out.println("Não foi possivél acessar a URL :" + BUSCAR_ESTADOS );
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<EstadoDTO> converterJsonToEstadoDTO( final String json ) {
		 try {
			Gson gson = new Gson();
			 return gson.fromJson (json, new TypeToken<List<EstadoDTO>>(){}.getType());
		} catch (JsonSyntaxException e) {
			System.out.println("Não foi possivél listar os estados ");
			e.printStackTrace();
		}
		 return null;
	}
	
	public  static List<EstadoDTO> listarEstados (){
		 return  converterJsonToEstadoDTO( buscarEstadosJon() ) ;
	}
}
