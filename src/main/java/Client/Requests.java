package Client;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Requests {

    public JSONArray getQuestions() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/Questions"))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
//            System.out.println(response.body().replaceAll("[,}]", "$0\n"));
            return new JSONArray(response.body());
        } else {
            System.out.println("Fehler: " + response.statusCode());
            return null;
        }
    }

    public JSONObject getQuestionById(int questionId) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/Questions/" + Integer.toString(questionId)))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
//            System.out.println(response.body().replaceAll("[,}]", "$0\n"));
            return new JSONObject(response.body());
        } else {
            System.out.println("Fehler: " + response.statusCode());
            return null;
        }
    }

    public JSONArray getQuestionByDiffucultyId(int difficultyId) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/Questions/Difficulty/" + Integer.toString(difficultyId)))
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
//            System.out.println(response.body().replaceAll("[,}]", "$0\n"));
            return new JSONArray(response.body());
        } else {
            System.out.println("Fehler: " + response.statusCode());
            return null;
        }
    }
}
