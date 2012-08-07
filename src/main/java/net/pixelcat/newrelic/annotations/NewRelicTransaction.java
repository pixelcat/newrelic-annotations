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
 * Define a transaction to capture in new relic
 *
 * Annotation equivalent of {@see com.newrelic.api.agent.NewRelic#setTransactionName(name, category)}
 */
public @interface NewRelicTransaction
{
    String transactionName();
    String category();
}
