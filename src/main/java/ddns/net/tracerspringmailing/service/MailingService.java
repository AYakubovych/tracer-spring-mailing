package ddns.net.tracerspringmailing.service;

import ddns.net.tracerspringmailing.payloads.FeedBackRequest;
import ddns.net.tracerspringmailing.payloads.KeySendRedirectionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailingService {

    private JavaMailSender javaMailSender;

    public void sendFeedback(FeedBackRequest request) throws MailException {
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo("a.yakubovych@yahoo.com");
        mail.setFrom(request.getEmail());
        mail.setSubject("Feedback");
        mail.setText(request.getMessage() +
                '\n' + '\n' +
                request.getName() +
                '\n' +
                request.getEmail());

        javaMailSender.send(mail);
    }

    public void sendKeyOnMail(KeySendRedirectionRequest request) throws MailException{
        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(request.getEmail());
        mail.setFrom("bochkalo@yahoo.com");
        mail.setSubject("Key");

        mail.setText(request.getKey());

        javaMailSender.send(mail);
    }

    @Autowired
    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }
}

