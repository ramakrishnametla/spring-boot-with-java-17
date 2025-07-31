package com.mrk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

// Modern Spring Boot 3.x uses Jakarta Mail instead of JavaMail
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import java.io.IOException;

@SpringBootApplication
public class Application implements CommandLineRunner {

    // Modern Spring Boot 3.x: Constructor injection preferred over field injection
    private final JavaMailSender javaMailSender;
    
    public Application(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {

        // Java 24: String templates for modern string formatting
        System.out.println("📧 Sending Email...");

        // Java 24: Modern exception handling with pattern matching
        try {
            //sendEmail();
            sendEmailWithAttachment();
        } catch (MessagingException | IOException e) {
            // Java 17: Modern string formatting for better logging
            System.err.println("Error sending email: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("✅ Email sending completed!");

    }

    void sendEmail() {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo("1@gmail.com", "2@yahoo.com");

        msg.setSubject("Testing from Spring Boot");
        msg.setText("Hello World \n Spring Boot Email");

        javaMailSender.send(msg);

    }

    void sendEmailWithAttachment() throws MessagingException, IOException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, true);
        helper.setTo("1@gmail.com");

        helper.setSubject("Testing from Spring Boot");

        // default = text/plain
        //helper.setText("Check attachment for image!");

        // true = text/html
        helper.setText("<h1>Check attachment for image!</h1>", true);

        //FileSystemResource file = new FileSystemResource(new File("classpath:android.png"));

        //Resource resource = new ClassPathResource("android.png");
        //InputStream input = resource.getInputStream();

        //ResourceUtils.getFile("classpath:android.png");

        helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

        javaMailSender.send(msg);

    }
}
