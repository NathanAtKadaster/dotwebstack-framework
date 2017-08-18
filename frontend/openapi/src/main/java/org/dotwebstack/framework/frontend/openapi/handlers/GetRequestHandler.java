package org.dotwebstack.framework.frontend.openapi.handlers;

import java.util.Objects;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Response;
import org.dotwebstack.framework.informationproduct.InformationProduct;
import org.glassfish.jersey.process.Inflector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetRequestHandler implements Inflector<ContainerRequestContext, Response> {

  private static final Logger LOG = LoggerFactory.getLogger(GetRequestHandler.class);

  InformationProduct informationProduct;

  public GetRequestHandler(InformationProduct informationProduct) {
    this.informationProduct = Objects.requireNonNull(informationProduct);
  }

  @Override
  public Response apply(ContainerRequestContext containerRequestContext) {
    if (LOG.isDebugEnabled()) {
      LOG.debug("Handling {} request for path {}", containerRequestContext.getMethod(),
          containerRequestContext.getUriInfo().getPath());
    }

    return Response.ok(informationProduct.getIdentifier().stringValue()).build();
  }

}