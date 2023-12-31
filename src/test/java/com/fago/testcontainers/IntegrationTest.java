package com.fago.testcontainers;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableTestContainers
@SpringBootTest
@ActiveProfiles("test")
@CleanDbBeforeEach
public @interface IntegrationTest {

    @AliasFor("properties")
    String[] value() default {};

    @AliasFor("value")
    String[] properties() default {};

}
