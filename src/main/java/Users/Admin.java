package Users;

import org.javacord.api.event.message.MessageCreateEvent;

import static Validations.Validations.*;

public class Admin {

    public static void deleteMessage(MessageCreateEvent e, String u)
    {
        if(MessageStartsWith(u, "!clear"))
        {
            if(IsFollowedNumberUnder100(u) && IsFollowedNumberNotEmpty(u))
            {
                e.getMessage().addReaction("\uD83D\uDC4D");
                try {
                    e.getMessage().getMessagesBefore(Integer.parseInt(u.split(" ")[1])).get().deleteAll();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

    }
}