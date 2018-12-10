package com.arash.aliases.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@OriginalAnnotation
public @interface CustomAnnotation {

    @AliasFor(annotation = OriginalAnnotation.class, attribute = "name")
    String name() default "default_custom_annotation_name";
}
