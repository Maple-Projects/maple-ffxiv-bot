package com.github.emerycp.Functions;

import org.javacord.api.entity.message.Message;
import org.javacord.api.event.message.MessageCreateEvent;
import org.javacord.api.listener.message.MessageCreateListener;

import static com.github.emerycp.Utilisateurs.Admin.*;
import static com.github.emerycp.Utilisateurs.Bot.*;
import static com.github.emerycp.Utilisateurs.User.*;
import static com.github.emerycp.Validation.Validations.*;

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
