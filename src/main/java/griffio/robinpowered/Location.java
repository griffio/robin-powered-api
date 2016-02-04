package griffio.robinpowered;

import griffio.robinpowered.resources.LocationId;
import griffio.robinpowered.resources.LocationResource;
import griffio.robinpowered.resources.SpaceResource;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface Location {
  @GET("/locations/{id}")
  Call<LocationResource> get(@Path("id") LocationId id);

  @GET("/locations/{id}/spaces")
  Call<List<SpaceResource>> getSpaces(@Path("id") LocationId id);
}
