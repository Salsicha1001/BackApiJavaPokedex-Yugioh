package com.training.demo.Controller;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;


@RestController
@CrossOrigin("http://localhost:4200")
public class PokemonController {


    @GetMapping(value = "/getPokemons")
    public Object getAllPokemon() throws IOException, JSONException {


        JSONObject json = readJsonFromUrl("https://raw.githubusercontent.com/Biuni/PokemonGO-Pokedex/master/pokedex.json");
        JSONArray j = json.getJSONArray("pokemon");

          //  for(int i=0; i<j.length();i++){
            //    JSONObject o = j.getJSONObject(i);
              //  return o.toString();
            //}
        return j.toString();

    }
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }


}
