package gamewon;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WinningGame {

    public void wonTheGame() {


        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .build();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.chucknorris.io/jokes/random"))
                .build();

        try {
            HttpResponse<String> resp = httpClient.send(request,
                    HttpResponse.BodyHandlers.ofString());

            ObjectMapper objectMapper = new ObjectMapper();
            ChuckNorrisResponse response = objectMapper.
                    readValue(resp.body(),
                            ChuckNorrisResponse.class);

            System.out.println(response.getValue());


        } catch (
                IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}