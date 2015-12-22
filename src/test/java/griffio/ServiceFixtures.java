package griffio;

import griffio.robinpowered.Location;
import griffio.robinpowered.Space;
import griffio.robinpowered.resources.DeviceId;
import griffio.robinpowered.resources.BleDeviceResource;
import griffio.robinpowered.resources.LocationId;
import griffio.robinpowered.resources.LocationResource;
import griffio.robinpowered.resources.SpaceId;
import griffio.robinpowered.resources.SpaceResource;
import retrofit.Call;
import retrofit.Retrofit;
import retrofit.http.Path;
import retrofit.mock.Calls;

import java.util.List;
import java.util.UUID;

import static java.util.Collections.singletonList;
/**
 * Implementation of Services with hard-coded fixtures
 */
public class ServiceFixtures implements Space, Location {

  private final Retrofit retrofit;

  public ServiceFixtures(Retrofit retrofit) {
    this.retrofit = retrofit;
  }

  @Override
  public Call<List<BleDeviceResource>> getDevices(@Path("id") SpaceId id) {
    BleDeviceResource bleDeviceResource = BleDeviceResource.create(DeviceId.create(1L), "Test Device", UUID.randomUUID(), 1, 2);
    List<BleDeviceResource> response = singletonList(bleDeviceResource);
    return Calls.response(response, retrofit);
  }

  @Override
  public Call<SpaceResource> get(SpaceId id) {
    SpaceResource response = SpaceResource.create(id, "test space");
    return Calls.response(response, retrofit);
  }

  @Override
  public Call<LocationResource> get(LocationId id) {
    LocationResource response = LocationResource.create(id, "test location");
    return Calls.response(response, retrofit);
  }

  @Override
  public Call<List<SpaceResource>> getSpaces(@Path("id") LocationId id) {
    List<SpaceResource> response = singletonList(SpaceResource.create(SpaceId.create(1L), "Test"));
    return Calls.response(response, retrofit);
  }

}
