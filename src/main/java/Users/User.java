package Users;

import ffxiv.apiclient.RetrofitFFXIV;
import ffxiv.apiclient.ServiceFFXIV;
import ffxiv.dtos.CharacterByNameResponse;
import ffxiv.dtos.ItemResponse;
import ffxiv.dtos.Result;
import org.javacord.api.entity.message.embed.EmbedBuilder;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.entity.permission.Role;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static Validations.Validations.*;
import static java.lang.Integer.parseInt;

import java.util.List;

public class User {
    public static ServiceFFXIV serviceFFXIV = RetrofitFFXIV.getInstance().getService();

    // TODO Fix help command

    public static void help(MessageCreateEvent b, String u) {
        if (u.equalsIgnoreCase("!help")) {
            String message = "Hello! \n" + "Theses are the commands: \n" + "(**not** case sensitive) \n"
                    + "**!ffxiv**: Gain access to the Final Fantasy channels. \n" +
                    "*[...]*";

            b.getChannel().sendMessage(message);
        }
    }

    public static void ffhelp(MessageCreateEvent b, String u) {
        if (u.equalsIgnoreCase("!help ff")) {
            String message = "Hello! \n" + "Theses are the commands for FF14: \n" + "(**not** case sensitive) \n"
                    + "**!story + [ARR, HW, SB, SHB, END]**: Set every roles until the mentionned story. \n"
                    + "**!main + [TANK, HEALER, DPS]**: Set main class. You can only have one. \n"
                    + "**!sec + [TANK, HEALER, DPS]**: Set secondary class. \n" + "*[...]*";

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

    public static void assignFF14(MessageCreateEvent b, String u)
    {
        if(MessageStartsWith(u, "!ffxiv"))
        {
            Role ffRole = b.getServer().get().getRolesByName("FF14").get(0);
            b.getMessageAuthor().asUser().get().addRole(ffRole);
            b.getMessage().addReaction("👌");
        }
    }

    // region FFXIV
    public static void getItemById(final MessageCreateEvent event, final String userMessage) {
        if (MessageStartsWith(userMessage, "!item")) {
            if (IsFollowedNumber(userMessage)) {
                int itemId = parseInt(userMessage.split(" ")[1]);
                serviceFFXIV.getItem(itemId).enqueue(new Callback<ItemResponse>() {
                    @Override
                    public void onResponse(Call<ItemResponse> call, Response<ItemResponse> response) {
                        ItemResponse itemResponse = new ItemResponse();
                        if (response.isSuccessful()) {
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
            } else {
                event.getChannel().sendMessage("errorParam: ``NaN``");
            }
        }
    }

    public static void getCharacterBySearch(final MessageCreateEvent event, final String userMessage) {
        if (MessageStartsWith(userMessage, "!character")) {
            if (IsFollowedString(userMessage)) {
                String forename = userMessage.split(" ")[1];
                String surname = userMessage.split(" ")[2];
                String server = userMessage.split(" ")[3];
                serviceFFXIV.getCharacter(forename+ " " + surname, server).enqueue(new Callback<CharacterByNameResponse>() {
                    @Override
                    public void onResponse(Call<CharacterByNameResponse> call, Response<CharacterByNameResponse> response) {
                        Result character = new Result();
                        if (response.isSuccessful()) {

                            character = response.body().Results.get(0);
                            EmbedBuilder embed = new EmbedBuilder()
                                    .setTitle(character.Name)
                                    .addField("World / Datacenter", character.Server)
                                    .addField("ID", character.ID)
                                    .setThumbnail(character.Avatar)
                                    .addInlineField("Languages", character.Lang);

                            event.getChannel().sendMessage(embed);
                        } else {
                            event.getChannel().sendMessage("error:\n```json \n" + response.errorBody() + " \n```");
                        }
                    }

                    @Override
                    public void onFailure(Call<CharacterByNameResponse> call, Throwable t) {
                        event.getChannel().sendMessage("failure:\n`` " + t.getMessage() + " \n``");
                    }
                });
                
            } else {
                event.getChannel().sendMessage("errorParam: ``NaN``");
            }
        }
    }
    // endregion
}