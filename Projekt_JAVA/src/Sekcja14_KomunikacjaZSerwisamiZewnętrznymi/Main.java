package Sekcja14_KomunikacjaZSerwisamiZewnętrznymi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();

        final HttpResponse<String> httpResponse=client.send(HttpRequest.newBuilder()
                        .uri(URI.create("https://test-api.javaskills.pl/udemy/users"))
                        .GET()
                        .build(),
                HttpResponse.BodyHandlers.ofString());

        System.out.println(httpResponse); //(GET https://test-api.javaskills.pl/udemy/users) 200
        System.out.println(httpResponse.body()); //[{"id":1,"name":"John"},{"id":2,"name":"Jane"}]



    }
}
