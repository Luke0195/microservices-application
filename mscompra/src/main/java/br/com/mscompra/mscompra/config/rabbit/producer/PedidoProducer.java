package br.com.mscompra.mscompra.config.rabbit.producer;
import br.com.commonslib.dtos.response.PedidoResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PedidoProducer {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queue;
    private final ObjectMapper objectMapper;


    @SneakyThrows
    public void enviarPedido( PedidoResponseDto payload ){
        rabbitTemplate.convertAndSend(queue.getName(), payload) ;
    }
}
