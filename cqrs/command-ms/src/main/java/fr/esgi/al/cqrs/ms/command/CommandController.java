package fr.esgi.al.cqrs.ms.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommandController {

    private final KafkaTemplate<String, Object> template;

    public CommandController(KafkaTemplate<String, Object> template) {
        this.template = template;
    }

    @PostMapping(path = "/send/foo/{what}")
    public void pushMessage(@PathVariable String what) {
        this.template.send("topic1", new Message(what));
    }
}
