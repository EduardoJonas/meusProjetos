package info.dsandrade.pitagoras.jobs;

import com.google.gson.*;
import info.dsandrade.pitagoras.modelo.Escola;
import info.dsandrade.pitagoras.repository.EscolaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/jobs/registrarEscolas")
public class CadastrarEscolasJob {

    @Autowired
    EscolaRepository repository;
    @GetMapping("/aracaju")
    public void aracaju() throws IOException {
        URL urlGetEscolas = new URL("http://educacao.dadosabertosbr.com/api/escolas/buscaavancada?cidade=2800308");
        URLConnection conn = urlGetEscolas.openConnection();
        conn.connect();
        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            Gson gson = new GsonBuilder().create();
            JsonParser jsonParser = new JsonParser();
            JsonElement parse = jsonParser.parse(response.toString());
            JsonArray asJsonArray = parse.getAsJsonArray();

            Escola[] escolaApi = gson.fromJson(asJsonArray.get(1).toString(), (Type) Escola[].class);
            List<Escola> escolas = Arrays.asList(escolaApi);
            escolas.forEach(e -> {
                repository.save(e);
            });


        } catch (Exception i) {
            i.printStackTrace();
        }
    }
}
