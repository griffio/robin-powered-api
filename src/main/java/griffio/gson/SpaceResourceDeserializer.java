package griffio.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import griffio.robinpowered.resources.SpaceId;
import griffio.robinpowered.resources.SpaceResource;

import java.lang.reflect.Type;

/**
 * {
 * "id": 1,
 * "account_id": 3,
 * "device_manifest_id": 13,
 * "name": "PIR sensor",
 * "created_at": "2014-05-19T21:00:35+0000",
 * "updated_at": "2014-05-19T21:00:35+0000"
 * }
 */
public class SpaceResourceDeserializer implements JsonDeserializer<SpaceResource> {
  @Override
  public SpaceResource deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    JsonObject result = json.getAsJsonObject();

    return SpaceResource.create(SpaceId.create(result.get("id").getAsLong()), result.get("name").getAsString());

  }

}
