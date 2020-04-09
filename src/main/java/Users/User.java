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

    public static void assignStory(MessageCreateEvent b, String u)
    {
        if(MessageStartsWith(u, "!story"))
        {
            if(IsFollowedString(u))
            {
                String expansion = u.split(" ")[1].toLowerCase();
                List<Role> allRoles = b.getServer().get().getRoles();
                for (Role role : allRoles) {
                    
                    if(IsAllStoryRole(role))
                        b.getMessageAuthor().asUser().get().removeRole(role);

                    if(IsInCaseStoryRole(expansion, role))
                    {
                        b.getMessageAuthor().asUser().get().addRole(role);
                        b.getMessage().addReaction("👌");
                    }

                }
            }
        }
    }

    public static void assignMainClassType(MessageCreateEvent b, String u)
    {
        if(MessageStartsWith(u, "!main"))
        {
            if(IsFollowedString(u))
            {
                String classType = u.split(" ")[1].toLowerCase();
                List<Role> allRoles = b.getServer().get().getRoles();
                for (Role role : allRoles) {

                    if(IsAllMainClassType(role))
                        b.getMessageAuthor().asUser().get().removeRole(role);

                    if(IsInMainClassType(role, classType))
                    {
                        b.getMessageAuthor().asUser().get().addRole(role);
                        b.getMessage().addReaction("👌");
                    }
                }
            }
        }
    }

    public static void assignSecondaryClassType(MessageCreateEvent b, String u)
    {
        if(MessageStartsWith(u, "!sec"))
        {
            if(IsFollowedString(u))
            {
                String classType = u.split(" ")[1].toLowerCase();
                List<Role> allRoles = b.getServer().get().getRoles();
                for (Role role : allRoles) {

                    if(IsAllSecClassType(role))
                        b.getMessageAuthor().asUser().get().removeRole(role);

                    if(IsInSecClassType(role, classType))
                    {
                        b.getMessageAuthor().asUser().get().addRole(role);
                        b.getMessage().addReaction("👌");
                    }
                }
            }
        }
    }
}