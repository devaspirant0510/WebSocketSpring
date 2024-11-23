package ngod.project.websocketTest.controller

import ngod.project.websocketTest.model.Greeting
import ngod.project.websocketTest.model.HelloMessage
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller
import kotlin.math.log

@Controller
class MessageController {
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    fun greeting(message:HelloMessage):Greeting{
        println("message $message")
        return Greeting(content = "hello")

    }
    // 클라이언트가 /app/chat/{roomId}로 메시지를 보낼 때 호출
    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")  // 해당 방의 구독자에게 메시지 전송
    fun sendMessage(message: String, roomId: String): String {
        // 메시지 내용과 방 ID를 받아서 해당 방에만 메시지를 전송
        println("Room ID: $roomId, Message: $message")
        return "Message from room $roomId: $message"
    }


}