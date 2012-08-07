package net.pixelcat.newrelic.test;

import net.pixelcat.newrelic.annotations.NewRelicTransaction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;

/**
 * Copyright 2009 - WorkHabit, Inc. - acs
 * Date: 8/6/12, 9:02 PM
 */
@Ignore
public class TestTransaction
{
    private static Log log = LogFactory.getLog(TestTransaction.class);

    @NewRelicTransaction(transactionName = "/transaction/test", category="backend")
    public void doTransaction() {
        log.debug("Test transaction here");
    }
}
