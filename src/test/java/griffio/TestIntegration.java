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
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;

/**
 * Call the external Api with full stack. Requires client account access token or "401 Unauthorized"
 */
public class TestIntegration {

  private final Interceptor accessToken = new AccessTokenInterceptor("INSERT-ROBIN-POWERED-ACCESS-TOKEN");

  private Retrofit retrofit;

  @BeforeMethod
  public void restAdapter() throws Exception {

    OkHttpClient client = new OkHttpClient.Builder().addInterceptor(accessToken).build();

    Gson gson = new GsonBuilder()
        .registerTypeAdapter(BleDeviceResource.class, new DeviceResourceDeserializer())
        .registerTypeAdapter(LocationResource.class, new LocationResourceDeserializer())
        .registerTypeAdapter(SpaceResource.class, new SpaceResourceDeserializer())
        .registerTypeAdapterFactory(new RobinResourceTypeAdapterFactory())
        .create();

    retrofit = new Retrofit.Builder()
        .client(client)
        .baseUrl(Version.Api)
        .addConverterFactory(GsonConverterFactory.create(gson)).build();

  }

  @Test
  public void spaces() throws Exception {
    Location location = retrofit.create(Location.class);
    LocationResource locationResource = location.get(LocationId.create(239L)).execute().body();
    Truth.assertThat(locationResource).isNotNull();
  }
}