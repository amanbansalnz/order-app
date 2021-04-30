package org.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SpringFoxConfig {
    @Bean
    public OpenAPI customOpenAPI(@Value("${serverVersion}") String appVersion, @Value("${serverName}") String serverName) {

        Server server3 = new Server();
        server3.setUrl("http://localhost:9000");

        List<Server> servers = new ArrayList<>();
        servers.add(server3);

        return new OpenAPI()
                .servers(servers)
                .info(new Info()
                              .title(serverName)
                              .version(appVersion)
                              .description("API please fill in ")
                              .termsOfService("http://swagger.io/terms/")
                              .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }

}