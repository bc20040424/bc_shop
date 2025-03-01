package com.ybc.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("appConfig")
public class AppConfig {
    @Value("${project.folder:}")
    private String folder;
    public String getProjectFolder(){
        return folder;
    }
}
