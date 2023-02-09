package com.javarush.spring03.processors;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BenchmarkAnnotationBeanPostProcessor implements BeanPostProcessor {

    private Class<?> currentClass;

    @Override
    public Object postProcessBeforeInitialization(Object bean, @NonNull String beanName) throws BeansException {
        System.out.println(">>>>" + beanName);
        currentClass = bean.getClass();
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        if (currentClass.isAnnotationPresent(Benchmark.class) || anyMethodIsTx(currentClass)) {
            bean = proxy(bean);
        }
        System.out.println("<<<<<" + beanName);
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    private boolean anyMethodIsTx(Class<?> currentClass) {
        return Arrays.stream(currentClass.getMethods())
                .anyMatch(m -> m.isAnnotationPresent(Benchmark.class));
    }

    private Object proxy(Object bean) {
        MethodInterceptor handler = (obj, method, args, proxy) -> {
            Object result;
            if (bean.getClass().isAnnotationPresent(Benchmark.class) || method.isAnnotationPresent(Benchmark.class)
            ) {
                System.out.printf("====  Method %s started ====%n", method.getName());
                long time = System.nanoTime();
                result = proxy.invoke(bean, args);
                time = System.nanoTime() - time;
                System.out.printf("====  Method %s complete. time = %.3f ms  ====%n%n", method.getName(), time / 1e6);
            } else {
                result = proxy.invoke(bean, args);
            }
            return result;
        };
        Object proxy = Enhancer.create(bean.getClass(), handler);
        System.out.println("here proxy for " + bean);
        return proxy;
    }
}
