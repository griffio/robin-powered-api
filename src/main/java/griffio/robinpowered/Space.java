package griffio.robinpowered;

import griffio.robinpowered.resources.BleDeviceResource;
import griffio.robinpowered.resources.SpaceId;
import griffio.robinpowered.resources.SpaceResource;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface Space {
  @GET("/spaces/{id}")
  Call<SpaceResource> get(@Path("id") SpaceId id);

  @GET("/spaces/{id}/devices")
  Call<List<BleDeviceResource>> getDevices(@Path("id") SpaceId id);

}
