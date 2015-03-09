package griffio;

import griffio.robinpowered.Version;
import org.testng.annotations.Test;
import retrofit.RestAdapter;

public class TestSpaces {

  @Test
  public void spaces() throws Exception {

    RestAdapter restAdapter = new RestAdapter.Builder()
        .setEndpoint(Version.Api)
        .build();

  }

}
