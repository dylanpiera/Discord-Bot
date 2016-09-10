package io.soaringdylan.discordbot.commands;

import io.soaringdylan.discordbot.Command;
import net.dv8tion.jda.events.message.MessageReceivedEvent;

public class ConnectingCavernCommand implements Command {
    @Override
    public boolean called(String[] args, MessageReceivedEvent event) {
        return true;
    }

    @Override
    public void action(String[] args, MessageReceivedEvent event) {

        String message = "The Connecting Cavern is a community server for the masses,\n\nOur idea is to create one big community out of the combined communities of content creators and the games they play.\nThis is done by inviting said content creators to invite their community to the server, creating a fun experience for their community, and make an opportunity to increase social traffic.\n\nBesides the main point of the server, we also provide other things, like tech support,  GFX requests and game specific chats. There is no main game to the Connecting Cavern. But a lot of our members and especially founders enjoy Pokemon.\nGame tournaments and other kinds of events are also planned for the future of the Connecting Cavern. Even one to celebrate it's launch!\n\n__*Are you ready to join the fun?*__\n\n**- Info (User)**:\nAs a user there is not much you have to do! All events will be announced in our announcement chat and so will any changes to the server. Our moderators make sure the server is clean so there is not much for you to worry about! Well. Besides having fun ofcourse!\n\nWhat you can do ofcourse, is join or create one of the many community channels. For more info check the Community Section Channel!\n\n**- Info (Content Creator)**:\nWelcome and thanks for joining our project. To invite members just use the same (public) invite link you've received to come in the server! \n\nBoth youtubers and streamers can promote and talk about their content in the #content-lobby ofcourse sharing your experience in other chats is not forbidden! Please keep self-promotions in the #content-channel as much as possible!";
        String message2 = "**Bonuses to being a Content Creator**:\n- Personalised invite link\n- A free webpage on our site\\*\n- Automated announcement when your stream goes live - made possible by Muxy Bot!\\*\\*\nYou can request these features or get more information about them by contacting @Soaringdylan#0793\n\n_\\*we provide a blank page to you which you may fill up. We do not construct the page for you. You will either need to create one your self or get someone to create one for you. The usage is free of charge. If you want access to a database a small fee will be applied. Contact @Soaringdylan#0793 for more information._\n_\\*\\*we do not own Muxy bot and only use it on our server and therefor can only give limited support about it. Contact @Soaringdylan#0793 for more information._\n\n**- Info (Helping Out)**:\nDo you just love the idea of our project? And do you want to help out as a moderator, or one of our server developers? Contact any of our @Administrators with why you love our project and what you could do to help us! And we'll be sure to find a spot for you!";

        if(event.isPrivate()) {
            event.getAuthor().getPrivateChannel().sendMessage(message);
            event.getAuthor().getPrivateChannel().sendMessage(message2);
        } else {
            event.getChannel().sendMessage(event.getAuthor().getAsMention() + " Sending !cc to you in a PM!");

            event.getAuthor().getPrivateChannel().sendMessage(message);
            event.getAuthor().getPrivateChannel().sendMessage(message2);
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
