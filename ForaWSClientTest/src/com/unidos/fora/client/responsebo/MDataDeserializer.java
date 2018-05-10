package com.unidos.fora.client.responsebo;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

public class MDataDeserializer implements JsonDeserializer<MData[]> {

	 @Override
	  public MData[] deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
	      throws JsonParseException
	  {
	    if (json instanceof JsonArray)
	    {
	      return new Gson().fromJson(json, MData[].class);
	    }
	    MData data = context.deserialize(json, MData.class);
	    return new MData[] { data };
	  }

	
}
