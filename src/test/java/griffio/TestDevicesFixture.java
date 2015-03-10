package griffio;

import com.google.common.truth.Truth;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import griffio.robinpowered.resources.DeviceResource;
import griffio.gson.DeviceResourceDeserializer;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.List;

public class TestDevicesFixture {

  @Test
  public void devices() throws Exception {

    String devicesFixture = Fixtures.fixture("devices.json");

    JsonObject page = new JsonParser().parse(devicesFixture).getAsJsonObject();

    Gson gson = new GsonBuilder().registerTypeAdapter(DeviceResource.class, new DeviceResourceDeserializer()).create();

    Type deviceListType = new TypeToken<List<DeviceResource>>() {}.getType();

    List<DeviceResource> deviceList = gson.fromJson(page.get("data"), deviceListType);

    Truth.ASSERT.that(deviceList).hasSize(2);

  }

}