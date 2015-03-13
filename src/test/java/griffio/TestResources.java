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
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;

import java.util.List;

import static com.google.common.truth.Truth.ASSERT;

public class TestResources {

  private static final ServiceFixtures fixtures = new ServiceFixtures();

  private MockRestAdapter mockAdapter;

  @BeforeMethod
  public void restAdapter() throws Exception {
    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Version.Api).build();
    mockAdapter = MockRestAdapter.from(restAdapter);
  }

  @Test
  public void location() throws Exception {
    Location location = mockAdapter.create(Location.class, fixtures);
    LocationResource locationResource = location.get(LocationId.create(1L));
    ASSERT.that(locationResource).isNotNull();
  }

  @Test
  public void space() throws Exception {
    Space space = mockAdapter.create(Space.class, fixtures);
    SpaceResource spaceResource = space.get(SpaceId.create(1L));
    ASSERT.that(spaceResource).isNotNull();
  }

  @Test
  public void spaces() throws Exception {
    Location location = mockAdapter.create(Location.class, fixtures);
    List<SpaceResource> spaceResource = location.getSpaces(LocationId.create(1L));
    ASSERT.that(spaceResource).hasSize(1);
  }

  @Test
  public void devices() throws Exception {
    Space space = mockAdapter.create(Space.class, fixtures);
    List<BleDeviceResource> deviceResource = space.getDevices(SpaceId.create(1L));
    ASSERT.that(deviceResource).hasSize(1);
  }

}