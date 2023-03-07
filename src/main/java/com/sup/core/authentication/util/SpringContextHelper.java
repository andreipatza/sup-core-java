package com.sup.core.authentication.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.sup.core.authentication.exception.JwtAuthenticationException;

import java.util.Collection;

@Component
public class SpringContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static <T> T getBean(Class<T> clazz) {
        Collection<T> beans = applicationContext.getBeansOfType(clazz).values();
        if (beans.isEmpty()) {
            throw new JwtAuthenticationException("No beans for class: " + clazz.getName() + " are loaded!");
        }

        if (beans.size() > 1) {
            throw new JwtAuthenticationException(
                    "More than one bean for class: " + clazz.getName() + " was identified!");
        }

        return clazz.cast(beans.iterator().next());
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextHelper.applicationContext = applicationContext;
    }
}
