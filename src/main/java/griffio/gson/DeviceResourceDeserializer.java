package griffio.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import griffio.robinpowered.resources.DeviceId;
import griffio.robinpowered.resources.BleDeviceResource;

import java.lang.reflect.Type;
import java.util.UUID;

public class DeviceResourceDeserializer implements JsonDeserializer<BleDeviceResource> {
  @Override
  public BleDeviceResource deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    JsonObject result = json.getAsJsonObject();

    DeviceId id = DeviceId.create(result.get("id").getAsLong());
    String name = result.get("name").getAsString();

    JsonObject identifiers = result.get("identifiers").getAsJsonArray().get(0).getAsJsonObject();

    UUID uuid = UUID.fromString(identifiers.get("uuid").getAsString());
    int major = identifiers.get("major").getAsInt();
    int minor = identifiers.get("minor").getAsInt();

    return BleDeviceResource.create(id, name, uuid, major, minor);

  }

}
