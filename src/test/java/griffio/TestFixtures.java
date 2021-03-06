package griffio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import griffio.gson.DeviceResourceDeserializer;
import griffio.gson.LocationResourceDeserializer;
import griffio.gson.RobinResourceTypeAdapterFactory;
import griffio.gson.SpaceResourceDeserializer;
import griffio.robinpowered.resources.BleDeviceResource;
import griffio.robinpowered.resources.LocationResource;
import griffio.robinpowered.resources.SpaceResource;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

/**
 * Just the Gson fixtures to be tested. Make sure Deserializers and adapters work.
 */
public class TestFixtures {

  private Gson gson;

  @BeforeMethod
  public void gsonTypeAdapters() throws Exception {
    gson = new GsonBuilder()
        .registerTypeAdapter(BleDeviceResource.class, new DeviceResourceDeserializer())
        .registerTypeAdapter(LocationResource.class, new LocationResourceDeserializer())
        .registerTypeAdapter(SpaceResource.class, new SpaceResourceDeserializer())
        .registerTypeAdapterFactory(new RobinResourceTypeAdapterFactory())
        .create();
  }

  @Test
  public void location() throws IOException {
    String fixture = Fixtures.fixture("fixtures/location.json");
    LocationResource actual = gson.fromJson(fixture, LocationResource.class);
    assertThat(actual).isNotNull();
  }

  @Test
  public void devices() throws Exception {
    String fixture = Fixtures.fixture("fixtures/devices.json");
    Type listType = new TypeToken<List<BleDeviceResource>>() {}.getType();
    List<BleDeviceResource> actualList = gson.fromJson(fixture, listType);
    assertThat(actualList).hasSize(2);
  }

  @Test
  public void spaces() throws Exception {
    String fixture = Fixtures.fixture("fixtures/spaces.json");
    Type listType = new TypeToken<List<SpaceResource>>() {}.getType();
    List<SpaceResource> actualList = gson.fromJson(fixture, listType);
    assertThat(actualList).hasSize(1);
  }

}