package com.shopee.ecommer.shopeebeemaildemo.config;

import com.shopee.ecommer.shopeebeemaildemo.listeners.EmailListener;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${custom.rabbit-mq.queue}")
    private String queueName;

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();

        container.setConnectionFactory(connectionFactory);
        container.setMessageListener(listenerAdapter);

        container.setQueueNames(queueName);

        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(EmailListener listener) {
        return new MessageListenerAdapter(listener, "onMessageReceived");
    }
}
