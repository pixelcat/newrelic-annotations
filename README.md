NewRelic Annotations
==

Library designed to allow new relic instrumentation of java applications using annotations.

Requirements
==

* Spring 2.5.6 or better
* AOP (aspectj)
* Java 1.6

Installation
==
* download and unzip New Relic java agent from rpm.newrelic.com (Account required).
* Install New Relic's newrelic-api.jar in your local maven repo:

```
cd /path/to/newrelic
mvn install:install-file -DgroupId=com.newrelic -DartifactId=newrelic-api -Dversion=2.7.0 -Dfile=newrelic-api.jar -Dpackaging=jar
```

* Checkout code from git and run:

```
mvn install
```

Use
==

A sample Application Context:

```xml
<?xml version="1.0"?>
<beans xmlns="http://www.springframework.org/schema/beans" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-2.5.xsd
       http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-2.5.xsd">

    <aop:aspectj-autoproxy/>

    <bean id="newRelicTransactionAdvice" class="net.pixelcat.newrelic.aop.NewRelicTransactionAdvice">
        <property name="newRelicProxy" ref="newRelicProxyBean"/>
    </bean>
    <bean id="testTransaction" class="net.pixelcat.newrelic.test.TestTransaction"/>
    <bean id="newRelicProxyBean" class="org.springframework.aop.framework.ProxyFactoryBean">
        <property name="targetSource" ref="newRelicProxySwappable"/>
    </bean>
    <bean id="newRelicProxySwappable" class="org.springframework.aop.target.HotSwappableTargetSource">
        <constructor-arg ref="newRelicProxy"/>
    </bean>

    <bean id="newRelicProxy" class="net.pixelcat.newrelic.support.NewRelicProxyImpl"/>
</beans>
```

And a sample java class:
```java
package net.pixelcat.newrelic.test;

import net.pixelcat.newrelic.annotations.NewRelicTransaction;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Copyright 2009 - WorkHabit, Inc. - acs
 * Date: 8/6/12, 9:02 PM
 */
public class TestTransaction
{
    private static Log log = LogFactory.getLog(TestTransaction.class);

    @NewRelicTransaction(transactionName = "/transaction/test", category="backend")
    public void doTransaction() {
        log.debug("Test transaction here");
    }
}
```

All Method Annotations available
==

* @NewRelicTransaction(transactionName = '', category = ''),  - declare a new transaction for instrumentation by New Relic, setting the transaction name and category
* @IgnoreApdex - Ignore the current method when calculating your application's ApDex score (extremely useful when dealing with Spring controllers!
* @IgnoreTransaction - Ignore the current transaction (e.g. do not send any information to new relic
