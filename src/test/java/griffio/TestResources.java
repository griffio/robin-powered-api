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
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.http.Path;
import retrofit2.mock.MockRetrofit;

import java.util.List;

import static com.google.common.truth.Truth.ASSERT;
/**
 * Test retrofit resources only
 */
public class TestResources {

  private MockServiceFixtures fixtures;

  @BeforeMethod
  public void restAdapter() throws Exception {
    Retrofit retrofit = new Retrofit.Builder().baseUrl(Version.Api).build();
    MockRetrofit mock = new MockRetrofit.Builder(retrofit).build();
    fixtures = new MockServiceFixtures(mock);
  }

  @Test
  public void location() throws Exception {
    LocationResource locationResource = fixtures.get(LocationId.create(1L)).execute().body();
    ASSERT.that(locationResource).isNotNull();
  }

  @Test
  public void space() throws Exception {
    SpaceResource spaceResource = fixtures.get(SpaceId.create(1L)).execute().body();
    ASSERT.that(spaceResource).isNotNull();
  }

  @Test
  public void spaces() throws Exception {
    List<SpaceResource> spaceResource = fixtures.getSpaces(LocationId.create(1L)).execute().body();
    ASSERT.that(spaceResource).hasSize(1);
  }

  @Test
  public void devices() throws Exception {
    List<BleDeviceResource> deviceResource = fixtures.getDevices(SpaceId.create(1L)).execute().body();
    ASSERT.that(deviceResource).hasSize(1);
  }

}