package Kruchkov.Task4;

import org.springframework.beans.BeansException;

import java.time.LocalDateTime;

public class BeanPostProcessorStart {
    public Object postProcessBeforeInitialization(Object bean,String beanName) throws BeansException {
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean,String beanName) throws BeansException {
             System.out.println("Before Bean '" + beanName + "' created : " + bean.toString());

                return bean;
    }

}
