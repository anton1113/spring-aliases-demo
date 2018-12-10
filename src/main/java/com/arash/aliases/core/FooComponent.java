package com.arash.aliases.core;

import com.arash.aliases.annotation.CustomAnnotation;
import com.arash.aliases.annotation.OriginalAnnotation;
import org.springframework.stereotype.Component;

@Component
public class FooComponent {

    @OriginalAnnotation(name = "original_annotation_name")
    public void foo() {
        // perform foo
    }

    @CustomAnnotation(name = "custom_annotation_name")
    public void bar() {
        // perform bar
    }
}
