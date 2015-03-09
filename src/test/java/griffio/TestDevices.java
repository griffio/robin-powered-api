package griffio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import griffio.robinpowered.resources.DeviceResource;
import griffio.gson.DeviceResourceDeserializer;
import org.testng.annotations.Test;

public class TestDevices {

  @Test
  public void devices() throws Exception {

    String devices = Fixtures.fixture("devices.json");

    Gson gson = new GsonBuilder()
        .registerTypeAdapter(DeviceResource.class, new DeviceResourceDeserializer())
        .create();

  }

}
