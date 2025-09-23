package vitor.tinelli.lista09.fipe.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class FipeModelosResponse {
    @JsonProperty("modelos")
    private List<FipeApiResponse> modelos;

    @JsonProperty("anos")
    private List<FipeApiResponse> anos;
}