package vitor.tinelli.lista09.fipe;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FipeResponse {

    @JsonProperty("Valor")
    private String valor;

    @JsonProperty("MesReferencia")
    private String mesReferencia;
}
