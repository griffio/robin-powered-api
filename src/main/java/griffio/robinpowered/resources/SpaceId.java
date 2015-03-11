package griffio.robinpowered.resources;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class SpaceId {

  SpaceId() {
  }

  public abstract Long value();

  public static SpaceId create(Long id) {
    return new AutoValue_SpaceId(id);
  }

}
