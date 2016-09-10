package io.soaringdylan.discordbot.commands;

import io.soaringdylan.discordbot.Command;
import io.soaringdylan.discordbot.util.Sneaky;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

/**
 * Created by dylan on 10-9-2016.
 */
public class InviteCommand implements Command {

    private final String HELP = "Usage: !invite";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if (event.getMessage().isPrivate()) {
            event.getChannel().sendMessage("You can invite us to your Server using this link: " + Sneaky.botinvite);
        }
    }

    @Override
    public String help() {
        return HELP;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
