package griffio.robinpowered.resources;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class SpaceResource {

  SpaceResource() {
  }

  public abstract Long id();

  public static SpaceResource create(Long id) {
    return new AutoValue_SpaceResource(id);
  }

}
