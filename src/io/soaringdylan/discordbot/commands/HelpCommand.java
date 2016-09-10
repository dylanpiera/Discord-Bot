package io.soaringdylan.discordbot.commands;

import io.soaringdylan.discordbot.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

public class HelpCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        if(event.isPrivate()) {
            event.getAuthor().getPrivateChannel().sendMessage("This is a list of all commands and their usage:" + "\n ```" +
                    "!help = Get to see this!" +
                    "\n!d (sides) = Roll a (sides) sided die." +
                    "\n!d (sides), (dice) = Roll (dice) amount of (sides) sided dice." +
                    "\n!ping = Pong!" +
                    "```");
        } else {
            event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Sending !help to you in a PM!");

            event.getAuthor().getPrivateChannel().sendMessage("This is a list of all commands and their usage:" + "\n ```" +
            "!help = Get to see this!" +
            "\n!d (sides) = Roll a (sides) sided die." +
            "\n!d (sides), (dice) = Roll (dice) amount of (sides) sided dice." +
            "\n!ping = Pong!" +
            "```");
        }
    }

    @Override
    public String help() {
        return null;
    }

    @Override
    public void executed(boolean success, MessageReceivedEvent event) {

    }
}
