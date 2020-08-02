package ddns.net.tracerspringmailing.web;

import ddns.net.tracerspringmailing.payloads.ApiResponse;
import ddns.net.tracerspringmailing.payloads.FeedBackRequest;
import ddns.net.tracerspringmailing.payloads.KeySendRedirectionRequest;
import ddns.net.tracerspringmailing.service.MailingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/key")
public class KeyController {

    private Logger logger = LoggerFactory.getLogger(KeyController.class);

    private MailingService mailingService;

    @PostMapping(path = "/send", produces = "application/json")
    public ApiResponse feedBack(@Valid @RequestBody KeySendRedirectionRequest request) {
        try{

            mailingService.sendKeyOnMail(request);
            logger.info("Mail sended");

        }catch (MailException e){

            logger.error("Error while mail sending: " + e.getMessage());
            return new ApiResponse(false,
                    e.getMessage());
        }

        return new ApiResponse(true, "Mail sended");
    }

    @Autowired
    public void setMailingService(MailingService mailingService) {
        this.mailingService = mailingService;
    }
}
