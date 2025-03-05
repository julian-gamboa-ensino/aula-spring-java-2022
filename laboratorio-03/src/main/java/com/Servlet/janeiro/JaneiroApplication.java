package com.Servlet.janeiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import jakarta.servlet.http.HttpServlet;

@SpringBootApplication
public class JaneiroApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(JaneiroApplication.class, args);
    }

    @Bean
    public ServletRegistrationBean<HttpServlet> meuServlet() {
        ServletRegistrationBean<HttpServlet> bean = new ServletRegistrationBean<>(
                new MeuServlet(), // Instância do seu servlet
                "/meu-servlet" // URL onde o servlet estará acessível
        );
        bean.setLoadOnStartup(1); // Configura a prioridade de carregamento
        return bean;
    }

}
