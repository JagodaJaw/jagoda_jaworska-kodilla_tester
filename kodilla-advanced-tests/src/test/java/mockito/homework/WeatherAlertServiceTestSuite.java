package mockito.homework;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WeatherAlertServiceTestSuite {

    private WeatherAlertService weatherAlertService = new WeatherAlertService();
    private Client client = Mockito.mock(Client.class);
    private Client secondClient = Mockito.mock(Client.class);
    private Client thirdClient = Mockito.mock(Client.class);
    private Notification notification = Mockito.mock(Notification.class);
    private Location warsaw = new Location("Warsaw");
    private Location krakow = new Location("Krakow");

    @Test
    public void subscribedClientShouldReceiveLocationNotification() {
        weatherAlertService.subscribe(client, warsaw);

        weatherAlertService.sendNotificationToLocation(notification, warsaw);

        Mockito.verify(client).receive(notification);
    }

    @Test
    public void clientShouldReceiveOnlyOneNotificationWhenSubscribedManyTimesToSameLocation() {
        weatherAlertService.subscribe(client, warsaw);
        weatherAlertService.subscribe(client, warsaw);
        weatherAlertService.subscribe(client, warsaw);

        weatherAlertService.sendNotificationToLocation(notification, warsaw);

        Mockito.verify(client).receive(notification);
    }

    @Test
    public void unsubscribedClientShouldNotReceiveLocationNotification() {
        weatherAlertService.subscribe(client, warsaw);
        weatherAlertService.unsubscribe(client, warsaw);

        weatherAlertService.sendNotificationToLocation(notification, warsaw);

        Mockito.verify(client, Mockito.never()).receive(notification);
    }

    @Test
    public void clientUnsubscribedFromAllLocationsShouldNotReceiveAnyNotifications() {
        weatherAlertService.subscribe(client, warsaw);
        weatherAlertService.subscribe(client, krakow);
        weatherAlertService.unsubscribeFromAllLocations(client);

        weatherAlertService.sendNotificationToLocation(notification, warsaw);
        weatherAlertService.sendNotificationToLocation(notification, krakow);

        Mockito.verify(client, Mockito.never()).receive(notification);
    }

    @Test
    public void locationNotificationShouldBeSentOnlyToClientsSubscribedToThatLocation() {
        weatherAlertService.subscribe(client, warsaw);
        weatherAlertService.subscribe(secondClient, warsaw);
        weatherAlertService.subscribe(thirdClient, krakow);

        weatherAlertService.sendNotificationToLocation(notification, warsaw);

        Mockito.verify(client).receive(notification);
        Mockito.verify(secondClient).receive(notification);
        Mockito.verify(thirdClient, Mockito.never()).receive(notification);
    }

    @Test
    public void notificationShouldBeSentToAllClients() {
        weatherAlertService.subscribe(client, warsaw);
        weatherAlertService.subscribe(secondClient, krakow);
        weatherAlertService.subscribe(thirdClient, warsaw);

        weatherAlertService.sendNotificationToAll(notification);

        Mockito.verify(client).receive(notification);
        Mockito.verify(secondClient).receive(notification);
        Mockito.verify(thirdClient).receive(notification);
    }

    @Test
    public void globalNotificationShouldBeSentOnlyOnceToClientSubscribedToManyLocations() {
        weatherAlertService.subscribe(client, warsaw);
        weatherAlertService.subscribe(client, krakow);

        weatherAlertService.sendNotificationToAll(notification);

        Mockito.verify(client).receive(notification);
    }

    @Test
    public void clientsShouldNotReceiveNotificationFromRemovedLocation() {
        weatherAlertService.subscribe(client, warsaw);
        weatherAlertService.removeLocation(warsaw);

        weatherAlertService.sendNotificationToLocation(notification, warsaw);

        Mockito.verify(client, Mockito.never()).receive(notification);
    }
}
