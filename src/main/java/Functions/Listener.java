package Functions;

import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import static Users.Admin.deleteMessage;
import static Users.User.*;
import static Validations.Validations.GetRoleFromUser;

public class Listener implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        // region Var

        Message eventMessage = event.getMessage();
        String userMessage = eventMessage.getContent();

        // endregion

        // region User

        help(event, userMessage);
        assignStory(event, userMessage);
        getItemById(event, userMessage);
        getCharacterBySearch(event, userMessage);
        getMateriaMeldingInfo(event, userMessage);

        // endregion

        // region Admin

        if (GetRoleFromUser(event)) {
            deleteMessage(event, userMessage);
        }

        // endregion

    }
}