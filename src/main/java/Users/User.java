package Users;

import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.entity.permission.Role;

import static Validations.Validations.*;

import java.util.List;

public class User {

    public static void help(final MessageCreateEvent b, final String u)
    {
        if(u.equalsIgnoreCase("!help"))
        {
            final String message = "Hello! \n"+
                    "Theses are the commands: \n" +
                    "(**not** case sensitive) \n" +
                    "**!story + [ARR, HW, SB, SHB, END]**: Set every roles until the mentionned story. \n" +
                    "**!main + [TANK, HEALER, DPS]**: Set main class. You can only have one. \n" +
                    "**!sec + [TANK, HEALER, DPS]**: Set secondary class. \n" +
                    "*[...]*";

            b.getChannel().sendMessage(message);
        }
    }

    public static void assignStory(final MessageCreateEvent b, final String u)
    {
        if(MessageStartsWith(u, "!story"))
        {
            if(IsFollowedString(u))
            {
                String expansion = u.split(" ")[1].toLowerCase();
                List<Role> allRoles = b.getServer().get().getRoles();
                for (Role role : allRoles) {
                    if(IsInCaseStoryRole(expansion, role))
                    {
                        // ToDo: Won't remove
                        if(IsAllStoryRole(role))
                            b.getMessageAuthor().asUser().get().removeRole(role);

                        b.getMessageAuthor().asUser().get().addRole(role);
                        b.getMessage().addReaction("👌");
                    }
                }
            }
        }
    }

    public static void assignMainClassType()
    {

    }

    public static void assignSecondaryClassType()
    {

    }
}