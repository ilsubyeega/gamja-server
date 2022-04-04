package roto.win.gamjaserver.listeners;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PingListener implements Listener {

    private final Component pingComponent = MiniMessage.miniMessage()
            .deserialize("<b><gradient:#ff711f:#ffbc63>감자야생:</gradient></b> <color:#ffbf75>생야생</color> <color:#009628>MC</color> <color:#33ff70>1.18.1</color>"
                    + "\n<color:#2469ff>Powered by </color><color:#709bff>https://minehub.kr</color> <color:#ffa1b2>(무료 호스팅)</color>");

    @EventHandler
    public void onPing(PaperServerListPingEvent event) {
        event.setHidePlayers(true);
        event.motd(pingComponent);

        event.setMaxPlayers(-1);
    }
}
