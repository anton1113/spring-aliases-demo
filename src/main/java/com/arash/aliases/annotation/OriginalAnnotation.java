package com.arash.aliases.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OriginalAnnotation {

    String name() default "default_original_annotation_name";
}
