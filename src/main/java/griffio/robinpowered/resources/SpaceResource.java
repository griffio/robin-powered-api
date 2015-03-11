package griffio.robinpowered.resources;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class SpaceResource {

  SpaceResource() {
  }

  public abstract SpaceId id();

  public abstract String name();

  public static SpaceResource create(SpaceId id, String name) {
    return new AutoValue_SpaceResource(id, name);
  }

}
