package win.roto.gamjaserver.listeners

import io.papermc.paper.event.player.AsyncChatEvent
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import win.roto.gamjaserver.CustomChatRenderer

class ChatListener : Listener {
    @EventHandler
    fun onChat(event: AsyncChatEvent) {
        event.renderer(CustomChatRenderer())
    }
}