package griffio.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import griffio.robinpowered.resources.DeviceResource;

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
public class DeviceResourceDeserializer implements JsonDeserializer<DeviceResource> {

  @Override
  public DeviceResource deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    JsonObject result = json.getAsJsonObject();

    return DeviceResource.create(result.get("id").getAsLong(), result.get("name").getAsString());

  }
}
