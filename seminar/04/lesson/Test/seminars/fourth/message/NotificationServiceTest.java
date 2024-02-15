package seminars.fourth.message;


import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class NotificationServiceTest {

    @Test
    void sendNotificationTest() {
        MessageService messageService = mock(MessageService.class);
        NotificationService notificationService = new NotificationService(messageService);

        notificationService.sendNotification("Hi!", "Ivan");

        verify(messageService, times(1)).sendMessage("Hi!", "Ivan");
    }
}