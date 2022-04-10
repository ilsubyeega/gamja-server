package win.roto.gamjaserver.listeners

import net.kyori.adventure.text.minimessage.MiniMessage
import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import win.roto.gamjaserver.GamjaServer

class JoinMessageListener : Listener {
    private val message: String =
        """
        <click:open_url:'https://minehub.kr/'><hover:show_text:'<color:#696969>클릭시 <color:#236669>https://minehub.kr/</color> 로 접속합니다.</color>'><color:#81898a>본 서버는 무료 서버 호스팅 서비스인 마인허브를 사용중입니다. (메시지 클릭)</color></hover></click>


        <color:#85ff78><u><player></u>님 <color:#2cb838>감자야생</color>에 오신 것을 환영합니다.</color>
        <color:#73fffa>현재 서버에 <color:#53b8b4><player_count></color>명이 접속중입니다. (최대 <player_max>명)</color>
        <hover:show_text:'클릭시 브라우저로 디스코드 주소에 이동합니다.'><click:open_url:'https://discord.gg/WU4FjHk'><color:#82a8ff>디스코드:</color> <color:#6583c7>discord.gg/WU4FjHk</color></click></hover>
        <color:#c3a6ff>명령어:</color> <click:suggest_command:'/msg'>/msg</click> <click:suggest_command:'/rules'>/rules</click>

        <color:#ffdb63>개발자의 한마디:</color> <message>""".trimIndent()

    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val placeholders = TagResolver.resolver(
            Placeholder.parsed("player", e.player.name),
            Placeholder.parsed("player_count", e.player.server.onlinePlayers.size.toString()),
            Placeholder.parsed("player_max", e.player.server.maxPlayers.toString()),
            Placeholder.component("message", GamjaServer.MOTD)
        )
        e.player.sendMessage(MiniMessage.miniMessage().deserialize(message, placeholders))
    }
}