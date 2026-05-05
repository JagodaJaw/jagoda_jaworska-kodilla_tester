package mockito.homework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WeatherAlertService {

    private final Map<Location, Set<Client>> subscriptions = new HashMap<>();

    public void subscribe(Client client, Location location) {
        subscriptions.computeIfAbsent(location, currentLocation -> new HashSet<>()).add(client);
    }

    public void unsubscribe(Client client, Location location) {
        if (subscriptions.containsKey(location)) {
            subscriptions.get(location).remove(client);
        }
    }

    public void unsubscribeFromAllLocations(Client client) {
        for (Set<Client> clients : subscriptions.values()) {
            clients.remove(client);
        }
    }

    public void sendNotificationToLocation(Notification notification, Location location) {
        if (subscriptions.containsKey(location)) {
            subscriptions.get(location).forEach(client -> client.receive(notification));
        }
    }

    public void sendNotificationToAll(Notification notification) {
        Set<Client> clients = new HashSet<>();
        subscriptions.values().forEach(clients::addAll);
        clients.forEach(client -> client.receive(notification));
    }

    public void removeLocation(Location location) {
        subscriptions.remove(location);
    }
}
