package griffio.robinpowered;

import griffio.robinpowered.resources.LocationId;
import griffio.robinpowered.resources.LocationResource;
import griffio.robinpowered.resources.SpaceResource;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;

public interface Location {
  @GET("/locations/{id}")
  Call<LocationResource> get(@Path("id") LocationId id);

  @GET("/locations/{id}/spaces")
  Call<List<SpaceResource>> getSpaces(@Path("id") LocationId id);
}
