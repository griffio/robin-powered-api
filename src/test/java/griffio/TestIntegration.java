package griffio;

import com.google.common.truth.Truth;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import griffio.gson.DeviceResourceDeserializer;
import griffio.gson.LocationResourceDeserializer;
import griffio.gson.RobinResourceTypeAdapterFactory;
import griffio.gson.SpaceResourceDeserializer;
import griffio.robinpowered.AccessTokenInterceptor;
import griffio.robinpowered.Location;
import griffio.robinpowered.Version;
import griffio.robinpowered.resources.BleDeviceResource;
import griffio.robinpowered.resources.LocationId;
import griffio.robinpowered.resources.LocationResource;
import griffio.robinpowered.resources.SpaceResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Call the external Api with full stack. Requires client account access token or "401 Unauthorized"
 */
public class TestIntegration {

  private static Logger log = LoggerFactory.getLogger(TestIntegration.class);

  private RestAdapter restAdapter;

  @BeforeMethod
  public void restAdapter() throws Exception {

    Gson gson = new GsonBuilder()
        .registerTypeAdapter(BleDeviceResource.class, new DeviceResourceDeserializer())
        .registerTypeAdapter(LocationResource.class, new LocationResourceDeserializer())
        .registerTypeAdapter(SpaceResource.class, new SpaceResourceDeserializer())
        .registerTypeAdapterFactory(new RobinResourceTypeAdapterFactory())
        .create();

    restAdapter = new RestAdapter.Builder()
        .setLog(new TestLog())
        .setLogLevel(RestAdapter.LogLevel.BASIC)
        .setRequestInterceptor(new AccessTokenInterceptor("FIXME"))
        .setConverter(new GsonConverter(gson))
        .setEndpoint(Version.Api).build();
  }

  @Test
  public void spaces() throws Exception {
    Location location = restAdapter.create(Location.class);
    LocationResource locationResource = location.get(LocationId.create(239L));
    Truth.ASSERT.that(locationResource).isNotNull();
  }

  static class TestLog implements RestAdapter.Log {
    @Override
    public void log(String message) {
      log.info(message);
    }
  }

}