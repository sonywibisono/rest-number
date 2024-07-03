package com.iconpln.restnumber;

import io.quarkus.runtime.annotations.ConfigDocMapKey;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

@Path("/book")
@ApplicationScoped
public class NumberResource {
    @ConfigDocMapKey("number.separator")
    boolean separator;
    private static Logger LOG = LoggerFactory.getLogger(NumberResource.class.getName());
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateBookNumbers() throws InterruptedException {
        LOG.info("Generation numbers");
        BookNumbers bookNumbers = new BookNumbers();
        bookNumbers.setIsbn10(RandomStringUtils.randomAlphanumeric(10).toUpperCase());
        bookNumbers.setIsbn13(RandomStringUtils.randomAlphanumeric(13).toUpperCase());
        bookNumbers.setAsin(RandomStringUtils.randomAlphanumeric(6).toUpperCase());
        bookNumbers.setEan8(RandomStringUtils.randomAlphanumeric(8).toUpperCase());
        bookNumbers.setEan13(RandomStringUtils.randomAlphanumeric(13).toUpperCase());
        bookNumbers.setGenerationDate(Instant.now());
        return Response.ok(bookNumbers).build();

    }
}
