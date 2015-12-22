package griffio;

import griffio.robinpowered.Location;
import griffio.robinpowered.Space;
import griffio.robinpowered.Version;

import griffio.robinpowered.resources.BleDeviceResource;
import griffio.robinpowered.resources.LocationId;
import griffio.robinpowered.resources.LocationResource;
import griffio.robinpowered.resources.SpaceId;
import griffio.robinpowered.resources.SpaceResource;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit.Retrofit;
import retrofit.mock.CallBehaviorAdapter;
import retrofit.mock.MockRetrofit;
import retrofit.mock.NetworkBehavior;

import java.util.List;
import java.util.concurrent.Executors;

import static com.google.common.truth.Truth.ASSERT;
/**
 * Test retrofit resources only
 */
public class TestResources {

  private ServiceFixtures fixtures;

  private MockRetrofit mock;

  @BeforeMethod
  public void restAdapter() throws Exception {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(Version.Api).build();
    fixtures = new ServiceFixtures(retrofit);
    mock = new MockRetrofit(NetworkBehavior.create(), new CallBehaviorAdapter(retrofit, Executors.newSingleThreadExecutor()));
  }

  @Test
  public void location() throws Exception {
    Location location = mock.create(Location.class, fixtures);
    LocationResource locationResource = location.get(LocationId.create(1L)).execute().body();
    ASSERT.that(locationResource).isNotNull();
  }

  @Test
  public void space() throws Exception {
    Space space = mock.create(Space.class, fixtures);
    SpaceResource spaceResource = space.get(SpaceId.create(1L)).execute().body();
    ASSERT.that(spaceResource).isNotNull();
  }

  @Test
  public void spaces() throws Exception {
    Location location = mock.create(Location.class, fixtures);
    List<SpaceResource> spaceResource = location.getSpaces(LocationId.create(1L)).execute().body();
    ASSERT.that(spaceResource).hasSize(1);
  }

  @Test
  public void devices() throws Exception {
    Space space = mock.create(Space.class, fixtures);
    List<BleDeviceResource> deviceResource = space.getDevices(SpaceId.create(1L)).execute().body();
    ASSERT.that(deviceResource).hasSize(1);
  }

}