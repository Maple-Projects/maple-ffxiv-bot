package Validations;

import org.javacord.api.event.message.MessageCreateEvent;

public class Validations {

    public static boolean IsFollowedNumber(String m)
    {
        return (m.split(" ").length > 1 && m.split(" ")[1].matches("^[1-9][0-9]?$|^100$"));
    }

    public static boolean IsFollowedNumberNotEmpty(String m)
    {
        return (m.split(" ").length > 1 && !m.split(" ")[1].isEmpty());
    }

    public static boolean MessageStartsWith(String m, String value)
    {
        return (m.toLowerCase().startsWith(value));
    }

    public static boolean GetRoleFromUser(MessageCreateEvent e)
    {
        return e.getMessageAuthor().isServerAdmin();
    }
}