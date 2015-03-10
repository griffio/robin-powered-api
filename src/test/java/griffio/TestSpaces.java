package griffio;

import com.google.common.truth.Truth;
import griffio.robinpowered.Spaces;
import griffio.robinpowered.Version;
import griffio.robinpowered.resources.SpaceResource;
import org.testng.annotations.Test;
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;

public class TestSpaces {

  @Test
  public void spaces() throws Exception {

    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Version.Api).build();

    MockRestAdapter mockAdapter = MockRestAdapter.from(restAdapter);

    Spaces spaces = mockAdapter.create(Spaces.class, new ServiceFixtures());

    SpaceResource spaceResource = spaces.get(1L);

    Truth.ASSERT.that(spaceResource).isNotNull();

  }

}
