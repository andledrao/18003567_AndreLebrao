package br.maua;

import br.maua.models.CLI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws Exception {
        CLI.run();
    }

    private static void leituraJava11() throws Exception{
        HttpClient client = HttpClient.newBuilder().build();
        HttpRequest request = HttpRequest.newBuilder().GET()
                .uri(URI.create("https://viacep.com.br/ws/09080320/json/"))
                .build();
        HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
        System.out.println("Status Code: "+response.statusCode());
        System.out.println("Recebidos");
        System.out.println(response.body());
    }

    private static void leituraJavaAte8()throws Exception{
        URL url = new URL("https://viacep.com.br/ws/09080320/json/");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        int statusCode = con.getResponseCode();
        System.out.println("Status Code: "+statusCode);
        BufferedReader in = new BufferedReader(
          new InputStreamReader(
                  con.getInputStream()
          )
        );

        String result;
        StringBuffer content = new StringBuffer();
        while((result = in.readLine())!=null){
            content.append(result);
        }
        in.close();
        System.out.println("Recebidos:");
        System.out.println(content);
    }
}
