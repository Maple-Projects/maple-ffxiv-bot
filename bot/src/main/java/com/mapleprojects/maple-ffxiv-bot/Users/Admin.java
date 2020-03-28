package com.github.emerycp.Utilisateurs;

import org.javacord.api.event.message.MessageCreateEvent;


import static com.github.emerycp.Validation.Validations.*;


public class Admin {

    public static void deleteMessage(MessageCreateEvent e, String u)
    {
        if(MessageStartsWith(u, "!clear"))
        {
            if(IsFollowedNumber(u) && IsFollowedNumberNotEmpty(u))
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
