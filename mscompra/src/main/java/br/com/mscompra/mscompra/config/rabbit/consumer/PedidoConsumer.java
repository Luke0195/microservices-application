package br.com.mscompra.mscompra.config.rabbit.consumer;

import br.com.commonslib.dtos.response.PedidoResponseDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PedidoConsumer {


    @RabbitListener(queues = {"${queue.name}"})
    public void consumer(@Payload PedidoResponseDto payload){
        System.out.println("Mensagem do consumer: " + payload);
        System.out.println(payload);
    }

}
