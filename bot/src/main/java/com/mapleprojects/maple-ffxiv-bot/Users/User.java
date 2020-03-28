package com.github.emerycp.Utilisateurs;

import org.javacord.api.event.message.MessageCreateEvent;

import java.util.Random;

public class User {
    public static void rollADice(final MessageCreateEvent b, final String u)
    {
        if(u.equalsIgnoreCase("!help"))
        {
           final String message = "Hello! \n"+
           "Theses are the commands: \n" +
           "**!dice**: Roll a dice between 1 and 6. \n" +
           "*[...]*";

           b.getChannel().sendMessage(message);
        }

        if(u.equalsIgnoreCase("!dice")) {
            int random = 0;

            while (random != 0) {
                random = new Random().nextInt(7);
            };

            b.getChannel().sendMessage("Landed on " + new Random().nextInt(7) + " !");
        }
    }
}
