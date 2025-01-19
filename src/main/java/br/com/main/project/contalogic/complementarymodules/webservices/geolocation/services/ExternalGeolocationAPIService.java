package br.com.main.project.contalogic.complementarymodules.webservices.geolocation.services;

import br.com.main.project.contalogic.complementarymodules.webservices.geolocation.DataConverter;
import br.com.main.project.contalogic.complementarymodules.webservices.geolocation.dtos.ExternalGeolocationRequestDTO;

import br.com.main.project.contalogic.complementarymodules.webservices.geolocation.dtos.GeolocationDataDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Objects;


@Service
public class ExternalGeolocationAPIService {

    private DataConverter dataConverter = new DataConverter();

    public ResponseEntity<Object> sendAddress(ExternalGeolocationRequestDTO dataApi){
        final String ADDRESS = "https://viacep.com.br/ws/" + dataApi.address() + "/json/";
        String json = "";
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(ADDRESS))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            json = response.body();
            if (response.statusCode() == 404 || response.statusCode() == 400) {
                return ResponseEntity.badRequest().body("O formato do CEP informado é inválido. ");
            }
            if (dataApi.address().length() != 8) {
                return ResponseEntity.badRequest().body("A quantidade de números informada no CEP é inválida, tente novamente. ");
            }
            if (Objects.equals(response.body(), """
                    {
                      "erro": "true"
                    }""")){
                return ResponseEntity.badRequest().body("O CEP informado é inexistente, tente novamente. ");
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        GeolocationDataDTO address = dataConverter.getData(json, GeolocationDataDTO.class);
        return ResponseEntity.ok(address);
     }

    }

