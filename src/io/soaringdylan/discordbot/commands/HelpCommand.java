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

        String message = "Our sourcecode can be found over on discord: https://github.com/dylanpiera/Soaring-Bot-JDA\n\nThis is a list of all commands and their usage:" + "\n ```" +
                "!help = Get to see this! [PM Only]" +
                "\n!d (sides) = Roll a (sides) sided die." +
                "\n!d (sides), (dice) = Roll (dice) amount of (sides) sided dice." +
                "\n!ping = Pong!" +
                "\n!cc = Information over the Connecting Caverns [PM Only]" +
                "\n!invite = Get a link to invite the bot to your server" +
                "```";

        if(event.isPrivate()) {
            event.getAuthor().getPrivateChannel().sendMessage(message);
        } else {
            event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Sending !help to you in a PM!");

            event.getAuthor().getPrivateChannel().sendMessage(message);
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
