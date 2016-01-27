package org.globex.usecase.service;

import org.apache.camel.Body;
import org.globex.globex.Account;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/customerservice/")
public interface CustomerRest {

    String[] Account = null;

	//@POST
    //@Path("/enrich")
    //@Consumes("application/json")
    //@Consumes("application/octet-stream")
    //@Consumes(Account)
    //@Consumes(MediaType.APPLICATION_JSON)
    @POST
   // @Path("/customerservice/enrich")
    @Path("/enrich")
    @Consumes("application/json")
    @Produces("application/json")
    Account enrich(Account customer);

}
