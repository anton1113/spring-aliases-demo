package com.arash.aliases;

import com.arash.aliases.annotation.OriginalAnnotation;
import com.arash.aliases.core.FooComponent;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.reflect.Method;

@SpringBootApplication
public class AliasesApplication {

    public static void main(String[] args) throws NoSuchMethodException {
        analyzeLowLevelAliasing();
        analyzeHighLevelAliasing();
//        SpringApplication.run(AliasesApplication.class, args);
    }

    private static void analyzeLowLevelAliasing() throws NoSuchMethodException {
        System.out.println("\n== Class loader level analysis ==");
        Class fooComponent = FooComponent.class;
        Method foo = fooComponent.getDeclaredMethod("foo", null);
        Method bar = fooComponent.getDeclaredMethod("bar", null);
        OriginalAnnotation fooOriginalAnnotation = AnnotationUtils.findAnnotation(foo, OriginalAnnotation.class);
        OriginalAnnotation barOriginalAnnotation = AnnotationUtils.findAnnotation(bar, OriginalAnnotation.class);
        System.out.println("Foo method original annotation name: " + fooOriginalAnnotation.name());
        System.out.println("Bar method original annotation name: " + barOriginalAnnotation.name());
    }

    private static void analyzeHighLevelAliasing() throws NoSuchMethodException {
        System.out.println("\n== Spring level analysis ==");
        Class fooComponent = FooComponent.class;
        Method foo = fooComponent.getDeclaredMethod("foo", null);
        Method bar = fooComponent.getDeclaredMethod("bar", null);
        AnnotationAttributes fooAnnotationAttributes = AnnotatedElementUtils.getMergedAnnotationAttributes(foo, OriginalAnnotation.class);
        AnnotationAttributes barAnnotationAttributes = AnnotatedElementUtils.getMergedAnnotationAttributes(bar, OriginalAnnotation.class);
        System.out.println("Foo method original annotation name: " + fooAnnotationAttributes.get("name"));
        System.out.println("Bar method original annotation name: " + barAnnotationAttributes.get("name"));
    }
}
