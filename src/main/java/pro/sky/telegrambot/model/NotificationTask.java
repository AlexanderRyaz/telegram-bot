package pro.sky.telegrambot.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class NotificationTask {
    @Id
    private Long id;
    private Long chatId;
    private String text;
    private LocalDateTime sentAt;

}
