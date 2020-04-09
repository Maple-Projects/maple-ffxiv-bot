package Functions;

import org.javacord.api.DiscordApiBuilder;

public class Main {
    public static void main(String[] args)
    {
        String token = Token.getToken();
        new DiscordApiBuilder().addListener(new Listener()).setToken(token).login().join();
    }
}