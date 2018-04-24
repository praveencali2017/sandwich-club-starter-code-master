package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        try {
            JSONObject jsonSandwich = new JSONObject(json);
            if(jsonSandwich!=null){
                Sandwich sandwich =new Sandwich();
                JSONObject name = jsonSandwich.getJSONObject("name");
                sandwich.setMainName(name.getString("mainName"));
                sandwich.setAlsoKnownAs(convertJsonArray((JSONArray) name.get("alsoKnownAs")));
                sandwich.setPlaceOfOrigin(jsonSandwich.getString("placeOfOrigin"));
                sandwich.setDescription(jsonSandwich.getString("description"));
                sandwich.setImage(jsonSandwich.getString("image"));
                sandwich.setIngredients(convertJsonArray((JSONArray) jsonSandwich.get("ingredients")));
                return sandwich;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }
    public static List<String> convertJsonArray(JSONArray jsonArray) throws JSONException{
        List<String> buffer = new ArrayList<String>();
        for(int i=0;i<jsonArray.length();i++){
            buffer.add(jsonArray.getString(i));
        }
        return buffer;
    }
}
