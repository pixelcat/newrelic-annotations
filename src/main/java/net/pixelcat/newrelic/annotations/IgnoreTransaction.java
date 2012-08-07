package net.pixelcat.newrelic.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright 2009 - WorkHabit, Inc. - acs
 * Date: 8/3/12, 1:31 AM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IgnoreTransaction
{
    // marker
}
