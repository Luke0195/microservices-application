package br.com.workercompras.service;

import br.com.commonslib.dtos.response.PedidoResponseDto;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender javaMailSender;


    public void notificarCliente(PedidoResponseDto pedidoResponseDto){
        try{
            MimeMessage message = javaMailSender.createMimeMessage();

            String emailBody = "<html>" +
                    "<head>" +
                    "<style>" +
                    "body { font-family: Arial, sans-serif; color: #333; }" +
                    "h2 { color: #0073e6; }" +
                    "footer { font-size: 0.9em; color: #888; }" +
                    "</style>" +
                    "</head>" +
                    "<body>" +
                    "<h2>Confirmação de Compra</h2>" +
                    "<p>Olá, <strong>" + pedidoResponseDto.nome() + "</strong>!</p>" +
                    "<p>Este é um e-mail de confirmação de compra recebida.</p>" +
                    "<p>A compra foi realizada com sucesso e está sendo validada. Em breve, você receberá um novo e-mail de confirmação.</p>" +
                    "<p>Obrigado por comprar conosco!</p>" +
                    "<hr>" +
                    "<footer>" +
                    "<p><small>Se você não reconhece esta compra, entre em contato com nosso suporte.</small></p>" +
                    "</footer>" +
                    "</body>" +
                    "</html>";
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setTo(pedidoResponseDto.email());
            messageHelper.setSubject("Compra efetuada");
            messageHelper.setText(emailBody, true);
            javaMailSender.send(message);
            log.info("Cliente notificado com successo!");

        }catch (Exception e ){
            e.printStackTrace();
        }
    }
}
