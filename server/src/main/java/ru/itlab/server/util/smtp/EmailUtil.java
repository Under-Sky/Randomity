package ru.itlab.server.util.smtp;

public interface EmailUtil {
    void sendEmail(String to, String subject, String from, String text);
}
