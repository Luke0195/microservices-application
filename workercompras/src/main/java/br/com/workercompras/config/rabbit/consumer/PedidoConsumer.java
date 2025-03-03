package br.com.workercompras.config.rabbit.consumer;

import br.com.commonslib.dtos.response.PedidoResponseDto;

import br.com.workercompras.service.EmailService;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PedidoConsumer {

    private final EmailService service;

    @RabbitListener(queues = { "COMPRA_EFETUADA"})
    public void consumer(@Payload PedidoResponseDto pedidoResponseDto) throws  Exception{
        service.notificarCliente(pedidoResponseDto);


    }
}
