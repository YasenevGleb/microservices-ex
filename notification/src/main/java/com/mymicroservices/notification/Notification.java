package com.mymicroservices.notification;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class Notification {
    @Id
    @SequenceGenerator(sequenceName = "notification_id", name = "notification_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "notification_id")
    private Integer id;
    private String notificationMessage;
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String sender;
    private LocalDateTime createdAt;
}
