package griffio.robinpowered;

import griffio.robinpowered.resources.SpaceResource;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * /spaces/466 Authorization:"Access-Token ABCD"
 */
public interface Spaces {
  @GET("/spaces/{id}") SpaceResource get(@Path("id") Long id);
}
