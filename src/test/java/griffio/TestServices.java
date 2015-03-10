package griffio;

import griffio.robinpowered.Locations;
import griffio.robinpowered.Spaces;
import griffio.robinpowered.resources.SpaceResource;

public class TestServices implements Spaces, Locations {

  @Override
  public SpaceResource get(Long id) {
    return SpaceResource.create(id);
  }

}
