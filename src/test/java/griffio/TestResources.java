package griffio;

import griffio.robinpowered.Location;
import griffio.robinpowered.Space;
import griffio.robinpowered.Version;

import griffio.robinpowered.resources.DeviceResource;
import griffio.robinpowered.resources.LocationId;
import griffio.robinpowered.resources.LocationResource;
import griffio.robinpowered.resources.SpaceId;
import griffio.robinpowered.resources.SpaceResource;
import org.testng.annotations.Test;
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;

import java.util.List;

import static com.google.common.truth.Truth.ASSERT;

public class TestResources {

  @Test
  public void location() throws Exception {

    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Version.Api).build();

    MockRestAdapter mockAdapter = MockRestAdapter.from(restAdapter);

    Location location = mockAdapter.create(Location.class, new ServiceFixtures());

    LocationResource locationResource = location.get(LocationId.create(1L));

    ASSERT.that(locationResource).isNotNull();

  }

  @Test
  public void space() throws Exception {

    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Version.Api).build();

    MockRestAdapter mockAdapter = MockRestAdapter.from(restAdapter);

    Space space = mockAdapter.create(Space.class, new ServiceFixtures());

    SpaceResource spaceResource = space.get(SpaceId.create(1L));

    ASSERT.that(spaceResource).isNotNull();

  }

  @Test
  public void spaces() throws Exception {

    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Version.Api).build();

    MockRestAdapter mockAdapter = MockRestAdapter.from(restAdapter);

    Location location = mockAdapter.create(Location.class, new ServiceFixtures());

    List<SpaceResource> spaceResource = location.getSpaces(LocationId.create(1L));

    ASSERT.that(spaceResource).hasSize(1);

  }

  @Test
  public void devices() throws Exception {

    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Version.Api).build();

    MockRestAdapter mockAdapter = MockRestAdapter.from(restAdapter);

    Space space = mockAdapter.create(Space.class, new ServiceFixtures());

    List<DeviceResource> deviceResource = space.getDevices(SpaceId.create(1L));

    ASSERT.that(deviceResource).hasSize(1);

  }

}