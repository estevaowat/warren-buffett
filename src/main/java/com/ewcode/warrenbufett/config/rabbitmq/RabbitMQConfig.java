package com.ewcode.warrenbufett.config.rabbitmq;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    private static final String ROUTING_KEY = "";
    private static final String EXCHANGE = "main";
    private static final boolean DURABLE = true;

    @Bean
    public ConnectionFactory createConnectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        return connectionFactory;
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue queueUserSave() {
        final String queueSaveUser = "/queue/user/save";
        return new Queue(queueSaveUser, DURABLE);
    }

    @Bean
    public Queue queueProcessSlow() {
        final String queueProcessSlow = "/queue/process/slow";
        return new Queue(queueProcessSlow, DURABLE);
    }

    @Bean
    Binding queueUserBinding(DirectExchange exchange) {
        return BindingBuilder.bind(queueUserSave())
                .to(exchange)
                .with(ROUTING_KEY);
    }

    @Bean
    Binding queueProcessBinding(DirectExchange exchange) {
        return BindingBuilder.bind(queueProcessSlow())
                .to(exchange)
                .with(ROUTING_KEY);
    }

    @Bean
    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        Jackson2JsonMessageConverter messageConverter = new Jackson2JsonMessageConverter();
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}
