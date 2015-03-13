package griffio;

import griffio.robinpowered.Location;
import griffio.robinpowered.Space;
import griffio.robinpowered.resources.DeviceId;
import griffio.robinpowered.resources.BleDeviceResource;
import griffio.robinpowered.resources.LocationId;
import griffio.robinpowered.resources.LocationResource;
import griffio.robinpowered.resources.SpaceId;
import griffio.robinpowered.resources.SpaceResource;
import retrofit.http.Path;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class ServiceFixtures implements Space, Location {

  @Override
  public List<BleDeviceResource> getDevices(@Path("id") SpaceId id) {
    return Collections.singletonList(BleDeviceResource.create(DeviceId.create(1L), "Test Device", UUID.randomUUID(), 1, 2));
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
