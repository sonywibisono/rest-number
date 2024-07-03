package com.iconpln.restnumber;

import io.quarkus.runtime.annotations.ConfigDocMapKey;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.javafaker.Faker;

import java.time.Instant;

@Path("/api/numbers/book")
@ApplicationScoped
public class NumberResource {
    @ConfigDocMapKey("number.separator")
    boolean separator;
    final Logger LOG = LoggerFactory.getLogger(NumberResource.class.getName());
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateBookNumbers() throws InterruptedException {
        LOG.info("Generation numbers");
        Faker faker = new Faker();
        BookNumbers bookNumbers = new BookNumbers();
        bookNumbers.setIsbn10(faker.code().isbn10(separator));
        bookNumbers.setIsbn13(faker.code().isbn13(separator));
        bookNumbers.setAsin(faker.code().asin());
        bookNumbers.setEan8(faker.code().ean8());
        bookNumbers.setEan13(faker.code().ean13());
        bookNumbers.setGenerationDate(Instant.now());
        return Response.ok(bookNumbers).build();

    }
}
