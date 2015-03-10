package griffio.robinpowered.resources;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class DeviceResource {

  DeviceResource() {
  }

  public abstract Long id();

  public abstract String name();

  public static DeviceResource create(Long id, String name) {
    return new AutoValue_DeviceResource(id, name);
  }

}
