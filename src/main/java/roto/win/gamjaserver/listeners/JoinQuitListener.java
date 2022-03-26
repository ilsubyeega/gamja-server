package roto.win.gamjaserver.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitListener implements Listener {
    private final Component joinMessage = Component.text("[+]", TextColor.color(0x85ff8d));
    private final Component quitMessage = Component.text("[-]", TextColor.color(0xff6678));

    private final Component header = MiniMessage.miniMessage().deserialize("""
            
            
            <color:#ff711f><b>감자야생 (one.il3.cc)</b></color>
            <color:#b8b8b8>디스코드: https://discord.gg/WU4FjHk</color>
            
            """);
    private final Component footer = MiniMessage.miniMessage().deserialize("""
            
            
            <color:#cfc851>본 서버는 Minehub의 무료 호스팅 서비스를 이용중입니다.
            https://minehub.kr/</color>
            
            """);

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.joinMessage(joinMessage.append(Component.text(" " + event.getPlayer().getName(), TextColor.color(0xbdffe8))));

        event.getPlayer().sendPlayerListHeader(header);
        event.getPlayer().sendPlayerListFooter(footer);
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.quitMessage(quitMessage.append(Component.text(" " + event.getPlayer().getName(), TextColor.color(0xffb5d5))));
    }
}
