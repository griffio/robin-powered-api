package griffio.robinpowered.resources;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class DeviceId {

  DeviceId() {
  }

  @Override
  public String toString() {
    return String.valueOf(value());
  }

  public abstract Long value();

  public static DeviceId create(Long id) {
    return new AutoValue_DeviceId(id);
  }

}
