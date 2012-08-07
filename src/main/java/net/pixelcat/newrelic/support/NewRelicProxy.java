package net.pixelcat.newrelic.support;

import com.newrelic.api.agent.Request;
import com.newrelic.api.agent.Response;

import java.util.Map;

/**
 * Copyright 2009 - WorkHabit, Inc. - acs
 * Date: 8/6/12, 10:04 PM
 */
public interface NewRelicProxy
{
    String getBrowserTimingFooter();

    void ignoreApdex();

    void addCustomParameter(String name, String value);

    void addCustomParameter(String name, Number value);

    String getBrowserTimingHeader();

    void ignoreTransaction();

    void incrementCounter(String name);

    void incrementCounter(String name, int count);

    void noticeError(String message);

    void noticeError(Throwable throwable);

    void noticeError(Throwable throwable, Map<String, String> params);

    void noticeError(String message, Map<String, String> params);

    void recordMetric(String name, float value);

    void setAccountName(String name);

    void setProductName(String name);

    void setRequestAndResponse(Request request, Response response);

    void setTransactionName(String category, String name);
}
