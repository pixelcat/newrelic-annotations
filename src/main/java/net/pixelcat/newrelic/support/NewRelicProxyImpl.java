package net.pixelcat.newrelic.support;

import com.newrelic.api.agent.NewRelic;
import com.newrelic.api.agent.Request;
import com.newrelic.api.agent.Response;

import java.util.Map;

/**
 * Copyright 2009 - WorkHabit, Inc. - acs
 * Date: 8/6/12, 10:04 PM
 */

/**
 * Concreete implementation of NewRelicProxy, to delegate to NewRelic static methods. This is used to make the NewRelic calls mockable.
 */
public class NewRelicProxyImpl implements NewRelicProxy
{
    /**
     * @see com.newrelic.api.agent.NewRelic#getBrowserTimingFooter()
     */
    public String getBrowserTimingFooter()
    {
        return NewRelic.getBrowserTimingFooter();
    }

    /**
     * @see com.newrelic.api.agent.NewRelic#ignoreApdex()
     */
    public void ignoreApdex()
    {
        NewRelic.ignoreApdex();
    }

    /**
     *
     * @see com.newrelic.api.agent.NewRelic#addCustomParameter(String, String)
     *
     * @param name
     * @param value
     */
    public void addCustomParameter(String name, String value)
    {
        NewRelic.addCustomParameter(name, value);
    }

    /**
     * @see com.newrelic.api.agent.NewRelic#addCustomParameter(String, Number)
     *
     * @param name
     * @param value
     */
    public void addCustomParameter(String name, Number value)
    {
        NewRelic.addCustomParameter(name, value);
    }

    /**
     * @see com.newrelic.api.agent.NewRelic#getBrowserTimingHeader()
     * @return
     */
    public String getBrowserTimingHeader()
    {
        return NewRelic.getBrowserTimingHeader();
    }

    /**
     * @see com.newrelic.api.agent.NewRelic#ignoreTransaction()
     */
    public void ignoreTransaction()
    {
        NewRelic.ignoreTransaction();
    }

    /**
     * @see com.newrelic.api.agent.NewRelic#incrementCounter(String)
     *
     * @param name
     */
    public void incrementCounter(String name)
    {
        NewRelic.incrementCounter(name);
    }

    /**
     * @see NewRelic#incrementCounter(String, int)
     *
     * @param name
     * @param count
     */
    public void incrementCounter(String name, int count)
    {
        NewRelic.incrementCounter(name, count);
    }

    /**
     * @see com.newrelic.api.agent.NewRelic#noticeError(String)
     *
     * @param message
     */
    public void noticeError(String message)
    {
        NewRelic.noticeError(message);
    }

    /**
     * @see com.newrelic.api.agent.NewRelic#noticeError(Throwable)
     * @param throwable
     */
    public void noticeError(Throwable throwable)
    {
        NewRelic.noticeError(throwable);
    }

    /**
     * @see com.newrelic.api.agent.NewRelic#noticeError(Throwable, java.util.Map)
     * @param throwable
     * @param params
     */
    public void noticeError(Throwable throwable, Map<String, String> params)
    {
        NewRelic.noticeError(throwable, params);
    }

    /**
     * @see com.newrelic.api.agent.NewRelic#noticeError(String, java.util.Map)
     * @param message
     * @param params
     */
    public void noticeError(String message, Map<String, String> params)
    {
        NewRelic.noticeError(message, params);
    }

    /**
     * @see com.newrelic.api.agent.NewRelic#recordMetric(String, float)
     * @param name
     * @param value
     */
    public void recordMetric(String name, float value)
    {
        NewRelic.recordMetric(name, value);

    }

    /**
     * @see com.newrelic.api.agent.NewRelic#setAccountName(String)
     * @param name
     */
    public void setAccountName(String name)
    {
        NewRelic.setAccountName(name);
    }

    /**
     * @see com.newrelic.api.agent.NewRelic#setProductName(String)
     * @param name
     */
    public void setProductName(String name)
    {
        NewRelic.setProductName(name);

    }

    /**
     * @see com.newrelic.api.agent.NewRelic#setRequestAndResponse(com.newrelic.api.agent.Request, com.newrelic.api.agent.Response)
     * @param request
     * @param response
     */
    public void setRequestAndResponse(Request request, Response response)
    {
        NewRelic.setRequestAndResponse(request, response);
    }

    /**
     * @see com.newrelic.api.agent.NewRelic#setTransactionName(String, String)
     * @param category
     * @param name
     */
    public void setTransactionName(String category, String name)
    {
        NewRelic.setTransactionName(category, name);
    }

}
