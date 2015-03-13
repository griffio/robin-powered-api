package griffio.robinpowered.resources;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class SpaceId {

  SpaceId() {
  }

  public abstract Long value();

  @Override
  public String toString() {
    return String.valueOf(value());
  }

  public static SpaceId create(Long id) {
    return new AutoValue_SpaceId(id);
  }

}
