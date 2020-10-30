package gamewon;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Player;
import textcolor.ColorText;
import utilities.additionalutilities.Additional;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class WinningGame {

    private final ColorText colorText = new ColorText();
    private final Additional additional = new Additional();
    private final Player player = new Player();

    public void wonTheGame() throws InterruptedException {

        if (player.getCoins() >= 100) {

            System.out.println(colorText.GREEN + "CONGRATULATIONS! YOU WON THE GAME! " +
                    "AS A REWARD, YOU CAN FIND RANDOM CHUCK NORRIS JOKE BELOW!" + colorText.TEXTRESET);

            additional.wait5Seconds();

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
                    IOException | InterruptedException e) {
                e.printStackTrace();
            }
            System.exit(0);
        }

    }
}