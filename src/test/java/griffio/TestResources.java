package griffio;

import griffio.robinpowered.Space;
import griffio.robinpowered.Version;
import griffio.robinpowered.resources.SpaceId;
import griffio.robinpowered.resources.SpaceResource;
import org.testng.annotations.Test;
import retrofit.MockRestAdapter;
import retrofit.RestAdapter;

import static com.google.common.truth.Truth.ASSERT;

public class TestResources {

  @Test
  public void spaces() throws Exception {

    RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(Version.Api).build();

    MockRestAdapter mockAdapter = MockRestAdapter.from(restAdapter);

    Space spaces = mockAdapter.create(Space.class, new ServiceFixtures());

    SpaceResource spaceResource = spaces.get(SpaceId.create(1L));

    ASSERT.that(spaceResource).isNotNull();

  }

}
