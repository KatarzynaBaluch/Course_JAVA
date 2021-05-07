import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class HttpMain {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newBuilder().build();

        //GET
        HttpResponse<String> httpResponse = client.send(HttpRequest.newBuilder()
                        .uri(URI.create("https://test-api.javaskills.pl/udemy/users"))
                        .GET()
                        .build(),
                HttpResponse.BodyHandlers.ofString());

        System.out.println(httpResponse); //(GET https://test-api.javaskills.pl/udemy/users) 200
        System.out.println(httpResponse.body()); //[{"id":1,"name":"John"},{"id":2,"name":"Jane"}]

        //przy użyciu: jackson-databind
        //aby to zadziałało w tej klasie której obiekty chcemy stworzyć muszą być settery
        ObjectMapper objectMapper = new ObjectMapper();

        CollectionType type = objectMapper.getTypeFactory().constructCollectionType(List.class, User.class);

        objectMapper.readValue(httpResponse.body(), type);

        List<User> users = objectMapper.readValue(httpResponse.body(), type);
        System.out.println(users); //[User(1): John, User(2): Jane]


        //______________________________________________
        
        //CREATE
        User newUser=new User();
        newUser.setN("Kasia");

        httpResponse=client.send(HttpRequest.newBuilder()
                        .uri(URI.create("https://test-api.javaskills.pl/udemy/users"))
                        .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(newUser)))
                        .build(),
                HttpResponse.BodyHandlers.ofString());

        System.out.println(httpResponse);
        
        
        //______________________________________________

        //UPDATE
        newUser.setN("Kasia2");

        httpResponse=client.send(HttpRequest.newBuilder()
                        .uri(URI.create("https://test-api.javaskills.pl/udemy/users/1")) // /1 id uzytkownika do updatu
                        .PUT(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(newUser)))
                        .build(),
                HttpResponse.BodyHandlers.ofString());

        System.out.println(httpResponse); //(PUT https://test-api.javaskills.pl/udemy/users/1) 200

        //______________________________________________

        //DELETE
        httpResponse=client.send(HttpRequest.newBuilder()
                        .uri(URI.create("https://test-api.javaskills.pl/udemy/users/1")) // /1 id uzytkownika do updatu
                        .DELETE()
                        .build(),
                HttpResponse.BodyHandlers.ofString());

        System.out.println(httpResponse); //(DELETE https://test-api.javaskills.pl/udemy/users/1) 200



        //______________________________________________
        System.out.println(httpResponse.statusCode());

    }
}
