package br.com.mscompra.mscompra.config.rabbit.producer;
import br.com.commonslib.dtos.response.PedidoResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
@RequiredArgsConstructor
public class PedidoProducer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;

    @PostMapping
    public void enviarPedido(@Payload PedidoResponseDto payload ){
        rabbitTemplate.convertAndSend(queue.getName(), payload) ;
    }
}
