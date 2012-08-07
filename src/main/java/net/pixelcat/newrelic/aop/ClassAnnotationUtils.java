package net.pixelcat.newrelic.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.BeanUtils;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Copyright 2009 - WorkHabit, Inc. - acs
 * Date: 8/4/12, 1:35 PM
 */
public class ClassAnnotationUtils
{
    public static <A extends Annotation> String getMethodWithAnnotation(Class sourceClass, Class<A> targetAnnotation)
    {
        Method[] methods = sourceClass.getMethods();
        for (Method method : methods) {
            Annotation annotation = AnnotationUtils.getAnnotation(method, targetAnnotation);
            if (annotation != null) {
                return BeanUtils.findPropertyForMethod(method).getName();
            }
        }
        // try on fields as well
        Field[] fields = sourceClass.getDeclaredFields();
        for (Field field : fields) {
            Annotation annotation = field.getAnnotation(targetAnnotation);
            if (annotation != null) {
                return field.getName();
            }
        }
        return null;
    }

    public static <A extends Annotation> A getAnnotationFromJoinPoint(ProceedingJoinPoint pjp, Class<A> targetAnnotation) {
        MethodSignature s = (MethodSignature)pjp.getSignature();
        Method method = s.getMethod();
        return method.getAnnotation(targetAnnotation);
    }

}
