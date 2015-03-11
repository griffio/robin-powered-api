package griffio.robinpowered.resources;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LocationResource {

  LocationResource() {
  }

  public abstract LocationId id();

  public static LocationResource create(LocationId id) {
    return new AutoValue_LocationResource(id);
  }

}
