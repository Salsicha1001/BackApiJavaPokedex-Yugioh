package com.training.demo.Controller;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;

@RestController
@CrossOrigin("http://localhost:4200")
public class YugiohController {


    @GetMapping(value = "/getCardsSpellequip")
        public String getAllCardsSpellEquip() throws IOException, JSONException {
        JSONObject json = readJsonFromUrl("https://db.ygoprodeck.com/api/v7/cardinfo.php?&type=spell%20card&race=equip&language=pt");
        JSONArray j = json.getJSONArray("data");

        return j.toString();
        }
    @GetMapping(value = "/getCardsCampo")
    public String getAllCardsCampo() throws IOException, JSONException {
        JSONObject json = readJsonFromUrl("https://db.ygoprodeck.com/api/v7/cardinfo.php?&type=spell%20card&race=field&language=pt");
        JSONArray j = json.getJSONArray("data");

        return j.toString();
    }
    @GetMapping(value = "/getCardspellQuick")
    public String getAllCardsQuickSpell() throws IOException, JSONException {
        JSONObject json = readJsonFromUrl("https://db.ygoprodeck.com/api/v7/cardinfo.php?&type=spell%20card&race=quick-play&language=pt");
        JSONArray j = json.getJSONArray("data");

        return j.toString();
    }
    @GetMapping(value = "/getCardspellContinuoes")
    public String getAllCardsContinuoesSpell() throws IOException, JSONException {
        JSONObject json = readJsonFromUrl("https://db.ygoprodeck.com/api/v7/cardinfo.php?&type=spell%20card&race=continuous&language=pt");
        JSONArray j = json.getJSONArray("data");

        return j.toString();
    }
    @GetMapping(value = "/getCardspellNormal")
    public String getAllCardsNormalSpell() throws IOException, JSONException {
        JSONObject json = readJsonFromUrl("https://db.ygoprodeck.com/api/v7/cardinfo.php?&type=spell%20card&race=normal&language=pt");
        JSONArray j = json.getJSONArray("data");

        return j.toString();
    }

    @GetMapping(value = "/getCardspellRitual")
    public String getAllCardsRitualSpell() throws IOException, JSONException {
        JSONObject json = readJsonFromUrl("https://db.ygoprodeck.com/api/v7/cardinfo.php?&type=spell%20card&race=ritual&language=pt");
        JSONArray j = json.getJSONArray("data");

        return j.toString();
    }

    @GetMapping(value = "/getCardMonsterNormal/{option}")
    public String getAllCardsMonsterNormal(@PathVariable  String option) throws IOException, JSONException {
        option = option.replace(" ","%20");
        JSONObject json = readJsonFromUrl("https://db.ygoprodeck.com/api/v7/cardinfo.php?type="+option+"&language=pt");
        JSONArray j = json.getJSONArray("data");
        return j.toString();

    }
    @GetMapping(value = "/getCardRace/{option}")
    public String getAllCardsMonsterRace(@PathVariable  String option) throws IOException, JSONException {
        option = option.replace(" ","%20");
        JSONObject json = readJsonFromUrl("https://db.ygoprodeck.com/api/v7/cardinfo.php?race="+option+"&language=pt");
        JSONArray j = json.getJSONArray("data");
        return j.toString();

    }
    @GetMapping(value = "/getCardMonster/{option}/{race}")
    public Object getAllCardsMonster(@PathVariable  String option, @PathVariable String race) throws IOException, JSONException {
        option = option.replace(" ","%20");
        race = race.replace(" ", "%20");
        URL url = new URL("https://db.ygoprodeck.com/api/v7/cardinfo.php?type="+option+"&race="+race+"&language=pt");
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        conn.setRequestMethod("GET");
        conn.connect();
        int responsecode = conn.getResponseCode();
        if(responsecode == 200){
        JSONObject json = readJsonFromUrl("https://db.ygoprodeck.com/api/v7/cardinfo.php?type="+option+"&race="+race+"&language=pt");
        JSONArray j = json.getJSONArray("data");
        return j.toString();
        }else{
            return false;
        }

    }
    @GetMapping(value = "/getCardTrap/{option}")
    public String getAllCardsTrap(@PathVariable  String option) throws IOException, JSONException {
        option = option.replace(" ", "%20");
        if (option != null) {
            JSONObject json = readJsonFromUrl("https://db.ygoprodeck.com/api/v7/cardinfo.php?type=trap%20card&race=" + option + "&language=pt");
            JSONArray j = json.getJSONArray("data");
            return j.toString();
        }
        return null;
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
