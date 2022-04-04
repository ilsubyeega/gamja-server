package roto.win.gamjaserver.listeners;

import io.papermc.paper.event.player.AsyncChatEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import roto.win.gamjaserver.CustomChatRenderer;

public class ChatListener implements Listener {

    @EventHandler
    public void onChat(AsyncChatEvent e) {
        e.renderer(new CustomChatRenderer());
    }
}
