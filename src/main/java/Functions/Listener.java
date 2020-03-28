package Functions;

import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import static Users.Admin.deleteMessage;
import static Users.Bot.angryFaceEmoji;
import static Users.User.rollADice;
import static Validations.Validations.GetRoleFromUser;

public class Listener implements MessageCreateListener {
    @Override
    public void onMessageCreate(MessageCreateEvent event) {

        // region Var

        Message eventMessage = event.getMessage();
        String userMessage = eventMessage.getContent();

        // endregion

        // region User

        rollADice(event, userMessage);
        angryFaceEmoji(event, userMessage);

        //endregion

        // region Admin

        if(GetRoleFromUser(event))
        {
            deleteMessage(event, userMessage);
        }

        //endregion

    }
}