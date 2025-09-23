package vitor.tinelli.lista09.fipe.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FipeApiResponse {

    @JsonProperty
    private String codigo;

    @JsonProperty
    private String nome;
}
