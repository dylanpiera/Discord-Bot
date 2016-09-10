package io.soaringdylan.discordbot;

import io.soaringdylan.discordbot.util.Log;
import io.soaringdylan.discordbot.util.Sneaky;
import net.dv8tion.jda.events.DisconnectEvent;
import net.dv8tion.jda.events.InviteReceivedEvent;
import net.dv8tion.jda.events.ReadyEvent;
import net.dv8tion.jda.events.ReconnectedEvent;
import net.dv8tion.jda.events.message.MessageReceivedEvent;
import net.dv8tion.jda.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.hooks.ListenerAdapter;
import net.dv8tion.jda.utils.InviteUtil;

/**
 * Created by dylan on 10-9-2016.
 */
public class BotListener extends ListenerAdapter{

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContent().startsWith("!") && event.getMessage().getAuthor().getId() != event.getJDA().getSelfInfo().getId()) Main.handleCommand(Main.parser.parse(event.getMessage().getContent().toLowerCase(), event));
    }

    @Override
    public void onReady(ReadyEvent event) {
        Log.logger("[Log]", "Logged in as: " + event.getJDA().getSelfInfo().getUsername());
    }

    @Override
    public void onReconnect(ReconnectedEvent event) {
        Log.logger("[Log]", "Reconnected to discord.");
    }

    @Override
    public void onDisconnect(DisconnectEvent event) {
        Log.logger("[Log]", "Disconnected to discord.");
    }

    /*@Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent event) {
        if(event.getMessage().getContent().startsWith("!invite")) {
            event.getChannel().sendMessage("You can invite us to your Server using this link: " + Sneaky.botinvite);
        }
    }*/

}
