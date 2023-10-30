package com.fago.testcontainers;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.Extension;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

public class CleanDbBeforeEachExtension implements BeforeEachCallback {

    @Override
    public void beforeEach(ExtensionContext extensionContext){
        Flyway flyway = SpringExtension.getApplicationContext(extensionContext).getBean(Flyway.class);
        flyway.clean();
        flyway.migrate();
    }
}
