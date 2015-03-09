package griffio.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import griffio.robinpowered.resources.DeviceResource;

import java.lang.reflect.Type;

public class DeviceResourceDeserializer implements JsonDeserializer<DeviceResource> {

  @Override
  public DeviceResource deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {

    JsonObject obj = json.getAsJsonObject();
    return null;
  }
}
