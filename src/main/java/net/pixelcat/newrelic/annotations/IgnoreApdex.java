package net.pixelcat.newrelic.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Copyright 2009 - WorkHabit, Inc. - acs
 * Date: 8/3/12, 1:33 AM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
/**
 * Marker interface. When integrated with {@see net.pixelcat.newrelic.aop.NewRelicTransactionAdvice} will not
 * apply current method to Apdex score.
 */
public @interface IgnoreApdex
{
    // marker
}
