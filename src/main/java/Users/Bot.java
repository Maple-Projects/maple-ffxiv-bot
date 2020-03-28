package Users;

import org.javacord.api.event.message.MessageCreateEvent;

public class Bot {

    public static void angryFaceEmoji(MessageCreateEvent b, String u)
    {
        if(u.equalsIgnoreCase("!angry")) {
            b.getChannel().sendMessage(":angry:");
            b.getMessage().delete();

        }
    }
}