package vitor.tinelli.lista09.fipe;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import vitor.tinelli.lista09.fipe.api.FipeApiResponse;
import vitor.tinelli.lista09.fipe.api.FipeModelosResponse;

@Service
@RequiredArgsConstructor
public class FipeService {

    private static final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";

    RestTemplate restTemplate = new RestTemplate();

    public String getMarcaId(String marcaDesejada) {
        try {
            String url = BASE_URL + "carros/marcas";
            FipeApiResponse[] marcas = restTemplate.getForObject(url, FipeApiResponse[].class);

            if (marcas == null) {
                throw new RuntimeException("Erro ao buscar marcas na API FIPE");
            }

            for (FipeApiResponse marca : marcas) {
                if (marca.getNome().equalsIgnoreCase(marcaDesejada)) {
                    return marca.getCodigo();
                }
            }
            throw new RuntimeException("Marca não encontrada: " + marcaDesejada);
        } catch (RestClientException e) {
            throw new RuntimeException("Erro ao comunicar com a API FIPE: " + e.getMessage(), e);
        }
    }

    public String getModeloId(String marcaId, String modeloDesejado) {
        try {
            String url = BASE_URL + "carros/marcas/" + marcaId + "/modelos";
            FipeModelosResponse response = restTemplate.getForObject(url, FipeModelosResponse.class);

            if (response == null || response.getModelos() == null) {
                throw new RuntimeException("Erro ao buscar modelos na API FIPE");
            }

            for (FipeApiResponse modelo : response.getModelos()) {
                if (modelo.getNome().toLowerCase().contains(modeloDesejado.toLowerCase())) {
                    return modelo.getCodigo();
                }
            }
            throw new RuntimeException("Modelo não encontrado: " + modeloDesejado);
        } catch (RestClientException e) {
            throw new RuntimeException("Erro ao comunicar com a API FIPE: " + e.getMessage(), e);
        }
    }

    public FipeResponse getValorFipe(String codigoMarca, String codigoModelo, String ano) {
        try {
            String url = BASE_URL + "carros/marcas/" + codigoMarca + "/modelos/" + codigoModelo + "/anos/" + ano;
            FipeResponse response = restTemplate.getForObject(url, FipeResponse.class);

            if (response == null) {
                throw new RuntimeException("Erro ao buscar valor na API FIPE");
            }

            return response;
        } catch (HttpServerErrorException.InternalServerError e) {
            throw new RuntimeException("A combinação de marca/modelo/ano não foi encontrada na tabela FIPE. " +
                    "Verifique se o ano está no formato correto (ex: '2014-3' para Diesel) e se o veículo existe na tabela.", e);
        } catch (RestClientException e) {
            throw new RuntimeException("Erro ao comunicar com a API FIPE: " + e.getMessage(), e);
        }
    }
}