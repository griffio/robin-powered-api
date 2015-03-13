package griffio.robinpowered;

import griffio.robinpowered.resources.BleDeviceResource;
import griffio.robinpowered.resources.SpaceId;
import griffio.robinpowered.resources.SpaceResource;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;

public interface Space {
  @GET("/spaces/{id}")
  SpaceResource get(@Path("id") SpaceId id);

  @GET("/spaces/{id}/devices")
  List<BleDeviceResource> getDevices(@Path("id") SpaceId id);

}
