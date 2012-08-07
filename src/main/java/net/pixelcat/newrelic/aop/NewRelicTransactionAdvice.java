package net.pixelcat.newrelic.aop;

import com.newrelic.api.agent.NewRelic;
import net.pixelcat.newrelic.annotations.IgnoreApdex;
import net.pixelcat.newrelic.annotations.IgnoreTransaction;
import net.pixelcat.newrelic.annotations.NewRelicTransaction;
import net.pixelcat.newrelic.support.NewRelicProxy;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.core.annotation.AnnotationUtils;

/**
 * Copyright 2009 - WorkHabit, Inc. - acs
 * Date: 8/4/12, 1:30 PM
 */
@Aspect
public class NewRelicTransactionAdvice
{
    private NewRelicProxy newRelicProxy;

    @Required
    public void setNewRelicProxy(NewRelicProxy newRelicProxy)
    {
        this.newRelicProxy = newRelicProxy;
    }

    @Around(value = "@annotation(apdex)", argNames = "pjp,apdex")
    public void ignoreApdex(ProceedingJoinPoint pjp, IgnoreApdex apdex) throws Throwable
    {
        newRelicProxy.ignoreApdex();
        pjp.proceed();
    }

    @Around(value = "@annotation(ignoreTransaction)", argNames = "pjp, ignoreTransaction")
    public void ignoreTransaction(ProceedingJoinPoint pjp, IgnoreTransaction ignoreTransaction) throws Throwable
    {
        newRelicProxy.ignoreTransaction();
        pjp.proceed();
    }

    @Around(value = "@annotation(net.pixelcat.newrelic.annotations.NewRelicTransaction)")
    public void newRelicTransaction(ProceedingJoinPoint pjp) throws Throwable
    {
        NewRelicTransaction relicTransaction = ClassAnnotationUtils.getAnnotationFromJoinPoint(pjp, NewRelicTransaction.class);
        String transactionName = (String)AnnotationUtils.getValue(relicTransaction, "transactionName");
        String category = (String)AnnotationUtils.getValue(relicTransaction, "category");
        newRelicProxy.setTransactionName(category, transactionName);
        pjp.proceed();
    }
}
