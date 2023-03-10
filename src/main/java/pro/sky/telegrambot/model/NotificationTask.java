package pro.sky.telegrambot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification_task")
@Data
public class NotificationTask {
    @Id
    private Long id;
    private Long chatId;
    private String text;
    private LocalDateTime sentAt;

}
