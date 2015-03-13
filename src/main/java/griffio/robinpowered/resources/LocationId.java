package griffio.robinpowered.resources;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LocationId {

  LocationId() {
  }

  public abstract Long value();

  @Override
  public String toString() {
    return String.valueOf(value());
  }

  public static LocationId create(Long id) {
    return new AutoValue_LocationId(id);
  }

}
