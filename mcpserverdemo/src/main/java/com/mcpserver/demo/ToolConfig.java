package com.mcpserver.demo;

import org.springframework.ai.support.ToolCallbacks;
import org.springframework.ai.tool.ToolCallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ToolConfig {
    @Bean
    public List<ToolCallback> productTools(ProductService productService) {
        return List.of(ToolCallbacks.from(productService));
    }
}
