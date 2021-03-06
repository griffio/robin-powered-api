package griffio;

import griffio.robinpowered.Version;
import griffio.robinpowered.resources.BleDeviceResource;
import griffio.robinpowered.resources.LocationId;
import griffio.robinpowered.resources.LocationResource;
import griffio.robinpowered.resources.SpaceId;
import griffio.robinpowered.resources.SpaceResource;
import java.util.List;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import retrofit2.Retrofit;
import retrofit2.mock.MockRetrofit;

import static com.google.common.truth.Truth.assertThat;

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
    assertThat(locationResource).isNotNull();
  }

  @Test
  public void space() throws Exception {
    SpaceResource spaceResource = fixtures.get(SpaceId.create(1L)).execute().body();
    assertThat(spaceResource).isNotNull();
  }

  @Test
  public void spaces() throws Exception {
    List<SpaceResource> spaceResource = fixtures.getSpaces(LocationId.create(1L)).execute().body();
    assertThat(spaceResource).hasSize(1);
  }

  @Test
  public void devices() throws Exception {
    List<BleDeviceResource> deviceResource = fixtures.getDevices(SpaceId.create(1L)).execute().body();
    assertThat(deviceResource).hasSize(1);
  }

}