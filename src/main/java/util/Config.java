package util;

import org.glassfish.jersey.server.ResourceConfig;

public class Config  extends ResourceConfig {

    public Config() {
        packages("resources");
    }
}