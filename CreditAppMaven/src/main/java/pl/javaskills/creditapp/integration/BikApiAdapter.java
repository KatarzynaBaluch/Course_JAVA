package pl.javaskills.creditapp.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.source.doctree.SeeTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.javaskills.creditapp.core.Constants;
import pl.javaskills.creditapp.core.bik.BikApi;
import pl.javaskills.creditapp.core.bik.ErrorResponse;
import pl.javaskills.creditapp.core.bik.ScoringRequest;
import pl.javaskills.creditapp.core.bik.ScoringResponse;
import pl.javaskills.creditapp.core.scoring.IncomeCalculator;

import javax.swing.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class BikApiAdapter implements BikApi {

    private static final Logger log= LoggerFactory.getLogger(BikApiAdapter.class);

    private static final HttpClient client=HttpClient.newBuilder().build();
    private static final ObjectMapper objectMapper=new ObjectMapper();

    private String token;
    {
        token=System.getenv("API_TOKEN");
        if(token==null)
        {
            throw new IllegalStateException("Missing env (token) variable");
        }
    }

    @Override
    public ScoringResponse getScoring(ScoringRequest scoringRequest) {


        try {
            HttpRequest httpRequest=HttpRequest.newBuilder()
                    .uri(new URI(Constants.BIK_API_ENDPOINT_URL))
                    .header("x-token", token)
                    .POST(HttpRequest.BodyPublishers.ofString(objectMapper.writeValueAsString(scoringRequest)))
                    .build();
            log.info(httpRequest.toString());
            HttpResponse<String> response=client.send(httpRequest,
                    HttpResponse.BodyHandlers.ofString());

            if(response.statusCode()!=200)
            {
                ErrorResponse errorResponse=objectMapper.readValue(response.body(), ErrorResponse.class);
                throw new IllegalStateException(errorResponse.getError());
            }
            else
            {

                return objectMapper.readValue(response.body(), ScoringResponse.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalStateException(("Unexpected eroor during communication with BIK API"));
        }



    }
}
