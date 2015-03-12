package griffio;

import griffio.robinpowered.Location;
import griffio.robinpowered.Space;
import griffio.robinpowered.resources.DeviceId;
import griffio.robinpowered.resources.DeviceResource;
import griffio.robinpowered.resources.LocationId;
import griffio.robinpowered.resources.LocationResource;
import griffio.robinpowered.resources.SpaceId;
import griffio.robinpowered.resources.SpaceResource;
import retrofit.http.Path;

import java.util.Collections;
import java.util.List;

public class ServiceFixtures implements Space, Location {

  @Override
  public List<DeviceResource> getDevices(@Path("id") SpaceId id) {
    return Collections.singletonList(DeviceResource.create(DeviceId.create(1L), "Test Device"));
  }

  @Override
  public SpaceResource get(SpaceId id) {
    return SpaceResource.create(id, "test space");
  }

  @Override
  public LocationResource get(LocationId id) {
    return LocationResource.create(id, "test location");
  }

  @Override
  public List<SpaceResource> getSpaces(@Path("id") LocationId id) {
    return Collections.singletonList(SpaceResource.create(SpaceId.create(1L), "Test"));
  }

}
