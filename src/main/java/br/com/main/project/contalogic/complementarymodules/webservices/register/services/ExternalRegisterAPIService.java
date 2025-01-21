package br.com.main.project.contalogic.complementarymodules.webservices.register.services;

import br.com.main.project.contalogic.complementarymodules.webservices.register.dtos.RegisterDataDTO;
import br.com.main.project.contalogic.complementarymodules.webservices.utilities.DataConverter;
import br.com.main.project.contalogic.complementarymodules.webservices.register.dtos.ExternalRegisterRequestDTO;
import br.com.main.project.contalogic.complementarymodules.webservices.utilities.ApiConnectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;


@Service
public class ExternalRegisterAPIService {

    @Autowired
    private DataConverter dataConverter;
    @Autowired
    private ApiConnectionService apiConnectionService;

    public ResponseEntity<Object> sendAddress(ExternalRegisterRequestDTO dataApi){
        final String ADDRESS = "https://brasilapi.com.br/api/cnpj/v1/" + dataApi.cnpj();
        HttpResponse<String> result = apiConnectionService.sendHttpResponse(ADDRESS);

        String json = result.body();
        if (result.statusCode() == 404 || result.statusCode() == 400) {
            return ResponseEntity.badRequest().body("O CNPJ não foi encontrado na base, tente novamente.");
        }
        if (dataApi.cnpj().length() != 14) {
            return ResponseEntity.badRequest().body("O CNPJ informado é inválido, tente novamente.");
        }
        RegisterDataDTO cnpj = dataConverter.getData(json, RegisterDataDTO.class);
        return ResponseEntity.ok(cnpj);
    }
}
