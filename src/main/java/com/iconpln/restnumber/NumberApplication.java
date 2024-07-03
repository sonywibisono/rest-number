package com.iconpln.restnumber;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@ApplicationPath("/api/numbers")
public class NumberApplication extends Application {
    private static Logger LOG= LoggerFactory.getLogger(NumberApplication.class.getName());
    void onStart(@Observes StartupEvent event){
        LOG.info("Application Started");
    }
    void onStop(@Observes ShutdownEvent event){
        LOG.info("Application Number Stopping");
    }
}
