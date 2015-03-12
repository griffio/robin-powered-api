package griffio.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import griffio.robinpowered.resources.LocationId;
import griffio.robinpowered.resources.LocationResource;

import java.lang.reflect.Type;

public class LocationResourceDeserializer implements JsonDeserializer<LocationResource> {
  @Override
  public LocationResource deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    JsonObject result = json.getAsJsonObject();

    return LocationResource.create(LocationId.create(result.get("id").getAsLong()), result.get("name").getAsString());

  }

}
