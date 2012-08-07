package net.pixelcat.newrelic.test;

import net.pixelcat.newrelic.support.NewRelicProxy;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.target.HotSwappableTargetSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Copyright 2009 - WorkHabit, Inc. - acs
 * Date: 8/6/12, 8:57 PM
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-test.xml" })
public class NewRelicTest
{
    private ApplicationContext context;

    @Resource(name = "testTransaction")
    TestTransaction testTransaction;

    @Resource(name = "newRelicProxySwappable")
    HotSwappableTargetSource newRelicProxySwappable;
    private Mockery mockery;

    @Before
    public void setUp() {
        mockery = new Mockery();
    }
    @Test
    public void testNewTransaction()
    {
        final NewRelicProxy newRelicProxy = mockery.mock(NewRelicProxy.class);
        mockery.checking(new Expectations() {
            {
                one(newRelicProxy).setTransactionName("backend", "/transaction/test");
            }
        });
        newRelicProxySwappable.swap(newRelicProxy);
        testTransaction.doTransaction();
        mockery.assertIsSatisfied();
    }
}
