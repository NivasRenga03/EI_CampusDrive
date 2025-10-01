package src.models;

import src.utils.Logger;

public class Email {
    public static void send(String to, String subject, String body) {
        Logger.log("Sending email to " + to + " with subject " + subject + " and body " + body);
        System.out.println("Email sent!");
    }
}