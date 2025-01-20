package br.com.main.project.contalogic.complementarymodules.webservices.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class ApiConnectionService {

    @Autowired
    private DataConverter dataConverter;

    public HttpResponse<String> sendHttpResponse(String addressUri){
        HttpResponse<String> httpResponse = null;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(addressUri))
                    .build();
            httpResponse = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return httpResponse;
    }
}
