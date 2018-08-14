package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        JSONObject mJSON;
        try {
            mJSON = new JSONObject(json);
            JSONObject name = mJSON.getJSONObject("name");
            String mainName = name.getString("mainName");
            String placeOfOrigin = mJSON.getString("placeOfOrigin");
            String description = mJSON.getString("description");
            String image = mJSON.getString("image");
            JSONArray mKnownAS = name.getJSONArray("alsoKnownAs");
            JSONArray mIngredients = mJSON.getJSONArray("ingredients");

            List<String> alsoKnownAs = new ArrayList<>();
            for (int i = 0; i < mKnownAS.length(); i++) {
                alsoKnownAs.add(mKnownAS.getString(i));
            }


            List<String> ingredients = new ArrayList<>();
            Log.d("Size" , mIngredients.length()+"");
            for (int j = 0; j < mIngredients.length(); j++) {
                ingredients.add(mIngredients.getString(j));
            }

            return new Sandwich(mainName , alsoKnownAs ,placeOfOrigin,description,image,ingredients);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
