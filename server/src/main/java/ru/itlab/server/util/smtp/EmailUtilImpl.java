package ru.itlab.server.util.smtp;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeUtility;
import java.util.concurrent.ExecutorService;

@Component
@Slf4j
public class EmailUtilImpl implements EmailUtil {
    @Setter
    @Getter
    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private ExecutorService executorService;

    @Override
    public void sendEmail(String to, String subject, String from, String text) {
        executorService.submit(
                () ->
                        mailSender.send(
                                mimeMessage -> {
                                    mimeMessage.setSubject(subject, "utf-8");
                                    mimeMessage.setHeader("Content-Type", " text/html; charset=utf-8");
                                    log.info("mimeMessageEncoding {}", mimeMessage.getEncoding());
                                    MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
                                    messageHelper.setFrom(from);
                                    messageHelper.setTo(to);
                                    messageHelper.setSubject(MimeUtility.encodeText(subject, "utf-8", "B"));
                                    log.info("messageHelperGetEncoding {}", messageHelper.getEncoding());
                                    messageHelper.setText(text, true);
                                }));
    }
}
