package griffio;

import com.google.common.truth.Truth;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import griffio.gson.DataResourceTypeAdapterFactory;
import griffio.gson.SpaceResourceDeserializer;
import griffio.robinpowered.resources.DeviceResource;
import griffio.gson.DeviceResourceDeserializer;
import griffio.robinpowered.resources.SpaceResource;
import org.testng.annotations.Test;

import java.lang.reflect.Type;
import java.util.List;

public class TestFixtures {

  @Test
  public void devices() throws Exception {

    String fixture = Fixtures.fixture("devices.json");

    Gson gson = new GsonBuilder()
        .registerTypeAdapterFactory(new DataResourceTypeAdapterFactory())
        .registerTypeAdapter(DeviceResource.class, new DeviceResourceDeserializer()).create();

    Type listType = new TypeToken<List<DeviceResource>>() {
    }.getType();

    List<DeviceResource> actualList = gson.fromJson(fixture, listType);

    Truth.ASSERT.that(actualList).hasSize(2);

  }

  @Test
  public void spaces() throws Exception {

    String fixture = Fixtures.fixture("spaces.json");

    Gson gson = new GsonBuilder()
        .registerTypeAdapterFactory(new DataResourceTypeAdapterFactory())
        .registerTypeAdapter(SpaceResource.class, new SpaceResourceDeserializer()).create();

    Type listType = new TypeToken<List<SpaceResource>>() {
    }.getType();

    List<SpaceResource> actualList = gson.fromJson(fixture, listType);

    Truth.ASSERT.that(actualList).hasSize(1);

  }

}