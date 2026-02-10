package com.notify.notification_service;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/notify")
public class NotificationController {
    
    @PostMapping("/alert")
    public String sendAlert(@RequestParam String email, @RequestParam String message) {
        System.out.println("--- SENDING EMAIL TO: " + email + " ---");
        System.out.println("MESSAGE: " + message);

        return "Notification sent successfully to " + email;
    }
    
}
