package griffio.robinpowered.resources;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LocationId {

  LocationId() {
  }

  public abstract Long value();

  public static LocationId create(Long id) {
    return new AutoValue_LocationId(id);
  }

}
