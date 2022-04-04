package roto.win.gamjaserver;

import io.papermc.paper.chat.ChatRenderer;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static net.kyori.adventure.text.format.TextColor.color;

public class CustomChatRenderer implements ChatRenderer {

    @Override
    public @NotNull Component render(@NotNull Player source, @NotNull Component sourceDisplayName, @NotNull Component message, @NotNull Audience viewer) {
        var component = Component.text();
        component.append(sourceDisplayName.color(color(0xc7ffff)));

        if (source.isOp())
            component.append(Component.text(" (관리자)", color(0xffabb2)));

        component.append(Component.text(" : ", color(0xd4d4d4)));
        if (source.isOp() && message instanceof TextComponent) {
            // ability to use minimessage syntax.
            var content = ((TextComponent) message).content();
            component.append(MiniMessage.miniMessage().deserialize(content));
        } else {
            component.append(message.color(color(0xF1F1F1)));
        }
        return component.build();
    }
}
