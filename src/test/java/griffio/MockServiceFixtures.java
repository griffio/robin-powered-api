package griffio;

import griffio.robinpowered.Location;
import griffio.robinpowered.Space;
import griffio.robinpowered.resources.DeviceId;
import griffio.robinpowered.resources.BleDeviceResource;
import griffio.robinpowered.resources.LocationId;
import griffio.robinpowered.resources.LocationResource;
import griffio.robinpowered.resources.SpaceId;
import griffio.robinpowered.resources.SpaceResource;
import retrofit2.Call;
import retrofit2.http.Path;
import retrofit2.mock.BehaviorDelegate;

import java.util.List;
import java.util.UUID;
import retrofit2.mock.MockRetrofit;

import static java.util.Collections.singletonList;
/**
 * Implementation of Services using BehaviorDelegate with hard-coded fixtures
 */
public class MockServiceFixtures implements Space, Location {

  private final BehaviorDelegate<Location> location;
  private final BehaviorDelegate<Space> space;

  public MockServiceFixtures(MockRetrofit mockRetrofit) {
    this.location = mockRetrofit.create(Location.class);
    this.space = mockRetrofit.create(Space.class);
  }

  @Override
  public Call<List<BleDeviceResource>> getDevices(@Path("id") SpaceId id) {
    BleDeviceResource bleDeviceResource = BleDeviceResource.create(DeviceId.create(1L), "Test Device", UUID.randomUUID(), 1, 2);
    List<BleDeviceResource> response = singletonList(bleDeviceResource);
    return space.returningResponse(response).getDevices(id);
  }

  @Override
  public Call<SpaceResource> get(SpaceId id) {
    SpaceResource response = SpaceResource.create(id, "test space");
    return space.returningResponse(response).get(id);
  }

  @Override
  public Call<LocationResource> get(LocationId id) {
    LocationResource response = LocationResource.create(id, "test location");
    return location.returningResponse(response).get(id);
  }

  @Override
  public Call<List<SpaceResource>> getSpaces(@Path("id") LocationId id) {
    List<SpaceResource> response = singletonList(SpaceResource.create(SpaceId.create(1L), "Test"));
    return location.returningResponse(response).getSpaces(id);
  }

}
