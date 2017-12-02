package com.wrapper.spotify.requests;

import com.google.common.collect.Maps;
import com.google.common.util.concurrent.SettableFuture;
import com.google.gson.JsonParser;
import com.wrapper.spotify.exceptions.*;

import java.io.IOException;
import java.util.Map;

public class ChangePlaylistDetailsRequest extends AbstractRequest {

  private ChangePlaylistDetailsRequest(final Builder builder) {
    super(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  public String get() throws
          IOException,
          NoContentException,
          BadRequestException,
          UnauthorizedException,
          ForbiddenException,
          NotFoundException,
          TooManyRequestsException,
          InternalServerErrorException,
          BadGatewayException,
          ServiceUnavailableException {
    return putJson();
  }

  public SettableFuture<String> getAsync() throws
          IOException,
          NoContentException,
          BadRequestException,
          UnauthorizedException,
          ForbiddenException,
          NotFoundException,
          TooManyRequestsException,
          InternalServerErrorException,
          BadGatewayException,
          ServiceUnavailableException {
    return getAsync(putJson());
  }

  public static final class Builder extends AbstractRequest.Builder<Builder> {

    final private Map<String, Object> properties = Maps.newHashMap();

    public Builder name(final String name) {
      assert (name != null);
      properties.put("name", name);
      return this;
    }

    public Builder publicAccess(final boolean isPublic) {
      properties.put("public", isPublic);
      return this;
    }

    @Override
    public ChangePlaylistDetailsRequest build() {
      setHeaderParameter("Content-Type", "application/json");
      setBodyParameter(new JsonParser().parse(properties.toString()).getAsJsonObject());
      return new ChangePlaylistDetailsRequest(this);
    }

  }

}
