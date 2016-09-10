package io.soaringdylan.discordbot.commands;


import io.soaringdylan.discordbot.Command;
import io.soaringdylan.discordbot.util.Log;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

import java.util.Random;

/**
 * Created by dylan on 10-9-2016.
 */
public class DiceCommand implements Command {

    private Random rand = new Random();

    private final String HELP = "Usage: !d [sides], [dice]";

    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {
        try {
            for (int x = 0; x < args.length; x++) {
                if (event.getMessage().getContent().contains(",")) {
                    String raw = args[x];
                    args[x] = raw.replace(",", "");
                    Log.logger("[Dice]", "Removed: args[" + x + "] comma.");
                }
            }

            try {
                String result = "";
                if (Integer.parseInt(args[1]) < 0) {
                    args[0] = "I'm here just to crash you for cheating.";
                    // Basically, I just make the program crash intentionally when the number is negative. Because, this was the easiest way for me to fix this? (atleast that I could think off)
                    result = result + (rand.nextInt(Integer.parseInt(args[0])) + 1);
                }
                for (int x = 0; x < Integer.parseInt(args[1]); x++) {
                    if (x != 0) result = result + ", ";

                    result = result + (rand.nextInt(Integer.parseInt(args[0])) + 1);
                }
                event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Rolled: " + result);

                Log.logger("[dice]", "Rolled multiple dice successfully.");
            } catch (ArrayIndexOutOfBoundsException e) {
                String result = "" + (rand.nextInt(Integer.parseInt(args[0])) + 1);
                event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Rolled: " + result);
                Log.logger("[dice]", "Rolled one dice successfully.");
            }
        } catch (ArrayIndexOutOfBoundsException|IllegalArgumentException e) {
            event.getChannel().sendMessage(event.getAuthor().getAsMention() + " the correct usage of this command is:\n`!d [sides], [dice]`\nAlso, be sure that both numbers are positive. for more info see !help");
            Log.logger("[dice]", "Telling " + event.getAuthor().getUsername() + " how to dice.");
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
