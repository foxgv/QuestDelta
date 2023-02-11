package com.javarush.spring03.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class TxAnnotationBeanPostProcessor implements BeanPostProcessor {

    private final Map<String, Class<?>> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        Class<?> aClass = bean.getClass();
        if (aClass.isAnnotationPresent(Tx.class) || methodIsAnnotationPresent(aClass)) {
            map.putIfAbsent(beanName, aClass);
            System.out.printf(">>> before init %s%n", beanName);
        }
        return bean;
    }

    private boolean methodIsAnnotationPresent(Class<?> aClass) {
        return Arrays.stream(aClass.getMethods())
                .anyMatch(m -> m.isAnnotationPresent(Tx.class));
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        Class<?> aClass = map.get(beanName);
        if (aClass != null) {
            bean = proxy(bean, aClass);
            System.out.printf("<<< after init %s%n", beanName);
        }
        return bean;
    }

    private Object proxy(Object beanOrProxy, Class<?> beanRealClass) {
        MethodInterceptor handler = (obj, method, args, proxy) -> {
            Object result;
            if (beanOrProxy.getClass().isAnnotationPresent(Tx.class)
                    || method.isAnnotationPresent(Tx.class)
            ) {
                System.out.printf("==  Tx %s started ==%n", method.getName());
                result = proxy.invoke(beanOrProxy, args);
                System.out.printf("==  Tx %s complete ==%n", method.getName());
            } else {
                result = proxy.invoke(beanOrProxy, args);
            }
            return result;
        };
        return Enhancer.create(beanRealClass, handler);
    }
}
