package com.example.bean_lifecycle_spring_data_jpa.beancycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class OldWay implements InitializingBean, DisposableBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("initializing bean with InitializingBean interface");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("distroying the bean with disposable bean interface");
    }
}
