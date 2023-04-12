package com.javatechie;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.togglz.core.manager.EmptyFeatureProvider;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.manager.FeatureManagerBuilder;
import org.togglz.core.spi.FeatureProvider;

@Configuration
public class TogglzConfig {


//    @Bean
//    public FeatureManager getFeatureManager(FeatureProvider featureProvider) {
//        return new FeatureManagerBuilder()
//                .featureProvider(featureProvider)
//                .build();
//    }
//
//    @Bean
//    public FeatureProvider featureProvider() {
//        return new EmptyFeatureProvider();
//    }
}