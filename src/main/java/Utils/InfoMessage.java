package Utils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InfoMessage {
    public static final String COMMAND_STRING = "!";
    public static String getCommand(String message){
        String command;
        if(message.trim().startsWith(COMMAND_STRING)){
            command = message.trim().toLowerCase().split(" ")[0].substring(1);
        } else {
            command = "";
        }
        return command;
    }
    public static List<String> getParams(String message){
        List<String> params;
        if(message.trim().startsWith(COMMAND_STRING)){
            params = Arrays.asList(message.trim().toLowerCase().split(" "));
            if(params.size() > 0){
                params.remove(0);
            }
        } else {
            params = new LinkedList<>();
        }
        return params;
    }
    public static List<String> getParams(String message, String customSeparator){
        List<String> params;
        if(message.trim().startsWith(COMMAND_STRING)){
            params = Arrays.asList(message.trim().toLowerCase().split(customSeparator));
            if(params.size() > 0){
                params.remove(0);
            }
        } else {
            params = new LinkedList<>();
        }
        return params;
    }

    public static String getFullParam(String message){
        String param;
        if(message.trim().startsWith(COMMAND_STRING)){
            int startParam = COMMAND_STRING.length() +  getCommand(message).trim().length();
            param = message.trim().substring(startParam);
        } else {
            param = "";
        }
        return param.trim();
    }
}
