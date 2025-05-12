package com.sorrymaker.java.ai.langchain4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.sorrymaker.java.ai.langchain4j")
public class KangruiApp {
    public static void main(String[] args) {
        SpringApplication.run(KangruiApp.class,args);
    }
}
