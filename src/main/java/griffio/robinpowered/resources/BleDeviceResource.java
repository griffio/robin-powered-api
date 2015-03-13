package griffio.robinpowered.resources;

import com.google.auto.value.AutoValue;

import java.util.UUID;

@AutoValue
public abstract class BleDeviceResource {

  BleDeviceResource() {
  }

  public abstract DeviceId id();

  public abstract String name();

  public abstract UUID uuid();

  public abstract int major();

  public abstract int minor();

  public static BleDeviceResource create(DeviceId id, String name, UUID uuid, int major, int minor) {
    return new AutoValue_BleDeviceResource(id, name, uuid, major, minor);
  }

}
