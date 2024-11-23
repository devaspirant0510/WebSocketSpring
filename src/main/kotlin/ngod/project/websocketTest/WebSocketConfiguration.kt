package ngod.project.websocketTest

import org.springframework.context.annotation.Configuration
import org.springframework.messaging.simp.config.MessageBrokerRegistry
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.config.annotation.*
import org.springframework.web.socket.handler.TextWebSocketHandler


@Configuration
@EnableWebSocketMessageBroker
class WebSocketConfiguration :WebSocketMessageBrokerConfigurer{
    override fun configureMessageBroker(registry: MessageBrokerRegistry) {
        println("configire message broker $registry")
        registry.enableSimpleBroker("/topic")// 메시지 처리 브로커
        registry.setApplicationDestinationPrefixes("/app") //
    }

    override fun registerStompEndpoints(registry: StompEndpointRegistry) {
        println("register stomp endpoint $registry")
        registry.addEndpoint("/gs-guide-websocket")
            .withSockJS()
    }
}