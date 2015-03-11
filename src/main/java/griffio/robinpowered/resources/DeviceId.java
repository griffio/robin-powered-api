package griffio.robinpowered.resources;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class DeviceId {

  DeviceId() {
  }

  public abstract Long value();

  public static DeviceId create(Long id) {
    return new AutoValue_DeviceId(id);
  }

}
