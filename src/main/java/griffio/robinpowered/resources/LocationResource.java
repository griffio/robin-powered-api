package griffio.robinpowered.resources;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class LocationResource {

  LocationResource() {
  }

  public abstract LocationId id();

  public abstract String name();

  public static LocationResource create(LocationId id, String name) {
    return new AutoValue_LocationResource(id, name);
  }

}
