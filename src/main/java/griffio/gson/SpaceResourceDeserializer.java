package griffio.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import griffio.robinpowered.resources.SpaceId;
import griffio.robinpowered.resources.SpaceResource;

import java.lang.reflect.Type;

public class SpaceResourceDeserializer implements JsonDeserializer<SpaceResource> {
  @Override
  public SpaceResource deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    JsonObject result = json.getAsJsonObject();
    return SpaceResource.create(SpaceId.create(result.get("id").getAsLong()), result.get("name").getAsString());
  }

}
