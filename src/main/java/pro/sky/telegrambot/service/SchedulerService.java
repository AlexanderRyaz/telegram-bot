package pro.sky.telegrambot.service;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.response.SendResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import pro.sky.telegrambot.model.NotificationTask;
import pro.sky.telegrambot.repository.NotificationTaskRepository;
import com.pengrad.telegrambot.request.SendMessage;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service

public class SchedulerService {
    private NotificationTaskRepository notificationTaskRepository;
    private TelegramBot telegramBot;

    @Autowired
    public SchedulerService(NotificationTaskRepository notificationTaskRepository, TelegramBot telegramBot) {
        this.notificationTaskRepository = notificationTaskRepository;
        this.telegramBot = telegramBot;
    }

    @Scheduled(cron = "0 0/1 * * * *")
    public void scheduler() {
        LocalDateTime currentTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        List<NotificationTask> allBySentAt = notificationTaskRepository.findAllBySentAt(currentTime);
        allBySentAt.forEach(notificationTask -> {
            SendMessage message = new SendMessage(notificationTask.getChatId(), notificationTask.getText());
            telegramBot.execute(message);
        });
    }
}
