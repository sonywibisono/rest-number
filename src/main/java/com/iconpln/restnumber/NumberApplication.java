package com.iconpln.restnumber;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class NumberApplication {
    private static Logger LOG= LoggerFactory.getLogger(NumberApplication.class.getName());
    void onStart(@Observes StartupEvent event){
        LOG.info("Application Started");
    }
    void onStop(@Observes ShutdownEvent event){
        LOG.info("Application Number Stopping");
    }
}
