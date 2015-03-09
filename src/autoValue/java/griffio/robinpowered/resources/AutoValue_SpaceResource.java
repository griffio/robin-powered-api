
package griffio.robinpowered.resources;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
final class AutoValue_SpaceResource extends SpaceResource {

  private final Long id;

  AutoValue_SpaceResource(
      Long id) {
    if (id == null) {
      throw new NullPointerException("Null id");
    }
    this.id = id;
  }

  @Override
  public Long id() {
    return id;
  }

  @Override
  public String toString() {
    return "SpaceResource{"
        + "id=" + id
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SpaceResource) {
      SpaceResource that = (SpaceResource) o;
      return (this.id.equals(that.id()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= id.hashCode();
    return h;
  }

}
