package com.example.demo.configurations;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI openAPI() {
        Info info = new Info();
        info.setTitle("Система управления аэропортом");
        info.setVersion("1.0.0");
        info.setDescription("Система для управления аэропортом, включая планирование рейсов и процессов перевозки пассажиров.\n" +
                "Основные функции системы:\n" +
                "- Управление расписанием рейсов и их статусами (отправление, прибытие, задержки);\n" +
                "- Координация распределения воздушных судов и экипажей;\n" +
                "- Управление регистрацией пассажиров и контроля посадки на рейсы;\n" +
                "- Отслеживание багажа и предоставление информации о его перемещении;\n");
        return new OpenAPI().info(info);
    }
}
