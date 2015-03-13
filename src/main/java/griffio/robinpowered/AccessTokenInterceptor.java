package griffio.robinpowered;

import retrofit.RequestInterceptor;

public class AccessTokenInterceptor implements RequestInterceptor {

  private final String accessToken;

  public AccessTokenInterceptor(String accessToken) {
    this.accessToken = accessToken;
  }

  @Override
  public void intercept(RequestFacade request) {
    request.addHeader("Authorization", "Access-Token ".concat(accessToken));
  }

}