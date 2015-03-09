package griffio.robinpowered.resources;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class DeviceResource {

  DeviceResource() {
  }

  public abstract Long id();

  public DeviceResource create(Long id) {
    return null;
  }

}
