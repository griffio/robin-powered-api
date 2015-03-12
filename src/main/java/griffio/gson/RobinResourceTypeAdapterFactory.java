package griffio.gson;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * "Type adapter factories are useful when several types share similar structure in their JSON form."
 *
 * Create type adapter to extract the json element from the "data" object
 */
public class RobinResourceTypeAdapterFactory implements TypeAdapterFactory {

  @Override
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {

    final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
    final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);

    return new TypeAdapter<T>() {

      public void write(JsonWriter out, T value) throws IOException {
        delegate.write(out, value);
      }

      public T read(JsonReader in) throws IOException {
        JsonElement jsonElement = elementAdapter.read(in);
        if (jsonElement.isJsonObject()) {
          JsonObject jsonObject = jsonElement.getAsJsonObject();
          if (jsonObject.has("data")) {
            jsonElement = jsonObject.get("data");
          }
        }
        return delegate.fromJsonTree(jsonElement);
      }
    }.nullSafe();
  }
}
