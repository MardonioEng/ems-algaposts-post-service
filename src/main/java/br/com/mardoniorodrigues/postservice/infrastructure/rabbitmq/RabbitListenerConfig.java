package br.com.mardoniorodrigues.postservice.infrastructure.rabbitmq;

import br.com.mardoniorodrigues.postservice.api.model.PostProcessingResult;
import br.com.mardoniorodrigues.postservice.domain.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RabbitListenerConfig {

    private final PostService postService;

    @RabbitListener(queues = RabbitConfig.RESULT_QUEUE)
    public void consumeProcessing(@Payload PostProcessingResult result) {
        postService.updatePostInfo(result);
    }
}
