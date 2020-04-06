package Users;

import ffxiv.apiclient.RetrofitFFXIV;
import ffxiv.apiclient.ServiceFFXIV;
import ffxiv.dtos.ItemResponse;
import ffxiv.dtos.SearchFCResponse;
import ffxiv.dtos.SearchFCResult;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.entity.permission.Role;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static Utils.InfoMessage.getCommand;
import static Utils.InfoMessage.getParams;
import static Validations.Validations.*;
import static Validations.Validations.MessageStartsWith;
import static java.lang.Integer.parseInt;

import java.util.List;

public class User {
    public static ServiceFFXIV serviceFFXIV = RetrofitFFXIV.getInstance().getService();
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

    // region FFXIV
    public static void getItemById(final MessageCreateEvent event, final String userMessage){
        if(MessageStartsWith(userMessage, "!item")){
            if(IsFollowedNumber(userMessage)){
                int itemId = parseInt(userMessage.split(" ")[1]);
                 serviceFFXIV.getItem(itemId).enqueue(new Callback<ItemResponse>() {
                     @Override
                     public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                         ItemResponse itemResponse = new ItemResponse();
                         if(response.isSuccessful()){
                             itemResponse = response.body();
                             event.getChannel().sendMessage("item name: " + itemResponse.Name);
                         } else {
                             event.getChannel().sendMessage("error:\n```json \n" + response.errorBody() + " \n```");
                         }
                     }
                     @Override
                     public void onFailure(Call<ItemResponse> call, Throwable t) {
                         event.getChannel().sendMessage("failure:\n`` " + t.getMessage() + " \n``");
                     }
                 });
            }
            else{
                event.getChannel().sendMessage("errorParam: ``NaN``");
            }
        }
    }

    public static void getFreeCompanyInfo(MessageCreateEvent event, final String userMessage){
        String command = getCommand(userMessage);
        if(!(command.equals("fc") || command.equals("freecompany"))){
            String fcName, server;
            List<String> params;
            //Si le name est entre ""
            if(userMessage.contains("\"")){
                params = getParams(userMessage, "\"");
            } else {
                params = getParams(userMessage);
            }
            fcName = params.get(0);
            //Si il y a un param après le name (server)
            if(params.size() > 1){
                server = params.get(1).trim();
            } else {
                server = null;
            }
            serviceFFXIV.getFreeCompanyByName(fcName, server).enqueue(new Callback<SearchFCResponse>() {
                @Override
                public void onResponse(Call<SearchFCResponse> call, Response<SearchFCResponse> response) {
                    if(response.isSuccessful()){
                        String name = response.body().Results.get(0).Name;
                        String id = response.body().Results.get(0).ID;
                        event.getChannel().sendMessage("Name: " + name + "\n Id: " + id);
                    }
                }

                @Override
                public void onFailure(Call<SearchFCResponse> call, Throwable t) {

                }
            });
        }

    }
    // endregion
}