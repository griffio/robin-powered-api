package griffio.robinpowered;

import griffio.robinpowered.resources.SpaceId;
import griffio.robinpowered.resources.SpaceResource;
import retrofit.http.GET;
import retrofit.http.Path;

public interface Space {
  @GET("/spaces/{id}")
  SpaceResource get(@Path("id") SpaceId id);
}
