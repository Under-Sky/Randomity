package ru.itlab.server.util.smtp;

import java.util.UUID;

public interface MailsGenerator {
    String getEmailforConfirm(String serverUrl, UUID userId);
}
