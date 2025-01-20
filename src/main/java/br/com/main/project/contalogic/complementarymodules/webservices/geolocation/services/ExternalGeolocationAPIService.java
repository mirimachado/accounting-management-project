package br.com.main.project.contalogic.complementarymodules.webservices.geolocation.services;

import br.com.main.project.contalogic.complementarymodules.webservices.utilities.DataConverter;
import br.com.main.project.contalogic.complementarymodules.webservices.geolocation.dtos.ExternalGeolocationRequestDTO;
import br.com.main.project.contalogic.complementarymodules.webservices.geolocation.dtos.GeolocationDataDTO;
import br.com.main.project.contalogic.complementarymodules.webservices.utilities.ApiConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.net.http.HttpResponse;
import java.util.Objects;


@Service
public class ExternalGeolocationAPIService {

    @Autowired
    private DataConverter dataConverter;
    @Autowired
    private ApiConnectionService apiConnectionService;

    public ResponseEntity<Object> sendAddress(ExternalGeolocationRequestDTO dataApi){
        final String ADDRESS = "https://viacep.com.br/ws/" + dataApi.address() + "/json/";
        HttpResponse<String> result = apiConnectionService.sendHttpResponse(ADDRESS);

        String json = result.body();
        if (result.statusCode() == 404 || result.statusCode() == 400) {
            return ResponseEntity.badRequest().body("O formato do CEP informado é inválido. ");
        }
        if (dataApi.address().length() != 8) {
            return ResponseEntity.badRequest().body("A quantidade de números informada no CEP é inválida, tente novamente. ");
        }
        if (Objects.equals(result.body(), """
                    {
                      "erro": "true"
                    }""")){
            return ResponseEntity.badRequest().body("O CEP informado é inexistente, tente novamente. ");
        }
        GeolocationDataDTO address = dataConverter.getData(json, GeolocationDataDTO.class);
        return ResponseEntity.ok(address);
      }

    }

