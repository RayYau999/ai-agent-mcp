package com.aiagent.demo;

import io.modelcontextprotocol.client.McpSyncClient;
import org.springframework.ai.mcp.SyncMcpToolCallbackProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

    // Put it here — very clean and works perfectly
    @Bean
    @Qualifier("my-mcp-server-callback-tool-provider")
    public SyncMcpToolCallbackProvider toolCallbackProvider(List<McpSyncClient> mcpSyncClients) {
        return new SyncMcpToolCallbackProvider(mcpSyncClients);
    }
}
