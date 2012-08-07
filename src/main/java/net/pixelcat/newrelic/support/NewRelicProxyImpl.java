package net.pixelcat.newrelic.support;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Request;
import com.newrelic.api.agent.Response;

import java.util.Map;

/**
 * Copyright 2009 - WorkHabit, Inc. - acs
 * Date: 8/6/12, 10:04 PM
 */
public class NewRelicProxyImpl implements NewRelicProxy
{

    public String getBrowserTimingFooter()
    {
        return NewRelic.getBrowserTimingFooter();
    }

    public void ignoreApdex()
    {
        NewRelic.ignoreApdex();
    }

    public void addCustomParameter(String name, String value)
    {
        NewRelic.addCustomParameter(name, value);
    }

    public void addCustomParameter(String name, Number value)
    {
        NewRelic.addCustomParameter(name, value);
    }

    public String getBrowserTimingHeader()
    {
        return NewRelic.getBrowserTimingHeader();
    }

    public void ignoreTransaction()
    {
        NewRelic.ignoreTransaction();
    }

    public void incrementCounter(String name)
    {
        NewRelic.incrementCounter(name);
    }

    public void incrementCounter(String name, int count)
    {
        NewRelic.incrementCounter(name, count);
    }

    public void noticeError(String message)
    {
        NewRelic.noticeError(message);
    }

    public void noticeError(Throwable throwable)
    {
        NewRelic.noticeError(throwable);
    }

    public void noticeError(Throwable throwable, Map<String, String> params)
    {
        NewRelic.noticeError(throwable, params);
    }

    public void noticeError(String message, Map<String, String> params)
    {
        NewRelic.noticeError(message, params);
    }

    public void recordMetric(String name, float value)
    {
        NewRelic.recordMetric(name, value);

    }

    public void setAccountName(String name)
    {
        NewRelic.setAccountName(name);
    }

    public void setProductName(String name)
    {
        NewRelic.setProductName(name);

    }

    public void setRequestAndResponse(Request request, Response response)
    {
        NewRelic.setRequestAndResponse(request, response);
    }

    public void setTransactionName(String category, String name)
    {
        NewRelic.setTransactionName(category, name);
    }

}
