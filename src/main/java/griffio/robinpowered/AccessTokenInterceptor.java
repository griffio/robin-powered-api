package griffio.robinpowered;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccessTokenInterceptor implements Interceptor {

  private final String accessToken;

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    request = request.newBuilder().header("Authorization", accessToken).build();
    return chain.proceed(request);
  }

  public AccessTokenInterceptor(String accessToken) {
    this.accessToken = String.format("Access-Token %s", accessToken);
  }
}