package com.github.andresgois;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)  // anotação apenas para classes
@Retention(RetentionPolicy.RUNTIME)
@Configuration
@Qualifier("cachorro")
public @interface Cachorro {
}
