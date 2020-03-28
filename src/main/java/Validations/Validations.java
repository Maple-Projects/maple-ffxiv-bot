package Validations;

import java.util.ArrayList;
import java.util.List;

import org.javacord.api.entity.permission.Role;
import org.javacord.api.event.message.MessageCreateEvent;

public class Validations {

    public static boolean IsFollowedNumber(final String m) {
        return (m.split(" ").length > 1 && m.split(" ")[1].matches("^[1-9][0-9]?$|^100$"));
    }

    public static boolean IsFollowedNumberNotEmpty(final String m) {
        return (m.split(" ").length > 1 && !m.split(" ")[1].isEmpty());
    }

    public static boolean MessageStartsWith(final String m, final String value) {
        return (m.toLowerCase().startsWith(value));
    }

    public static boolean GetRoleFromUser(final MessageCreateEvent e) {
        return e.getMessageAuthor().isServerAdmin();
    }

    public static boolean IsFollowedString(final String m)
    {
        return (m.split(" ").length > 1 && (m.split(" ")[1] instanceof String));
    }

    public static boolean IsAllStoryRole(Role role)
    {
        return (role.getName().equals("A Realm Reborn") || 
        role.getName().equals("Heavensward") ||
        role.getName().equals("Stormblood") ||
        role.getName().equals("Shadowbringers") ||
        role.getName().equals("End game"));
    }

    public static boolean IsInCaseStoryRole(String pCase, Role role)
    {

        if(pCase.equals("arr"))
            return role.getName().equals("A Realm Reborn");

        if(pCase.equals("hw"))
            return (role.getName().equals("A Realm Reborn") || 
            role.getName().equals("Heavensward"));

        if(pCase.equals("sb"))
            return (role.getName().equals("A Realm Reborn") || 
                                role.getName().equals("Heavensward") ||
                                role.getName().equals("Stormblood"));

        if(pCase.equals("shb"))
            return (role.getName().equals("A Realm Reborn") || 
            role.getName().equals("Heavensward") ||
            role.getName().equals("Stormblood") ||
            role.getName().equals("Shadowbringers"));

        if(pCase.equals("end"))
            return IsAllStoryRole(role);
        
        
        return false;
    }
}