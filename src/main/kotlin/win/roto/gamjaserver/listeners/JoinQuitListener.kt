package win.roto.gamjaserver.listeners

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor.color
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class JoinQuitListener : Listener {
    private val joinMessage: Component = Component.text("[+] ", color(0x85ff8d))
    private val quitMessage: Component = Component.text("[-] ", color(0xff6678))

    private val header: Component = MiniMessage.miniMessage().deserialize(
        """
        
            
        <b><gradient:#ff711f:#ffbc63>감자야생 (one.il3.cc)</gradient></b>
        <color:#b8b8b8>디스코드: https://discord.gg/WU4FjHk</color>
        
        """.trimIndent()
    )

    private val footer: Component = MiniMessage.miniMessage().deserialize(
        """
        
        
        <color:#cfc851>  본 서버는 <u>Minehub</u>의 무료 호스팅 서비스를 이용중입니다.  
        <u>https://minehub.kr/</u></color>
        
        """.trimIndent()
    )

    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        e.joinMessage(joinMessage.append(Component.text(e.player.name, color(0xbdffe8))))

        e.player.sendPlayerListHeader(header)
        e.player.sendPlayerListFooter(footer)
    }

    @EventHandler
    fun onQuit(e: PlayerQuitEvent) {
        e.quitMessage(quitMessage.append(Component.text(e.player.name, color(0xffb5d5))))
    }
}