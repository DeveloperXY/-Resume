package com.developerxy.resume.section.proj;

import java.lang.annotation.*;

/**
 * Created by Mohammed Aouf ZOUAG on 18/04/2017.
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Projects {
    String label() default "Projects";
    Project[] value();
}
