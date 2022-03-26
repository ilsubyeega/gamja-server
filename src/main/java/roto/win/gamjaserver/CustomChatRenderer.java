package roto.win.gamjaserver;

import io.papermc.paper.chat.ChatRenderer;
import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CustomChatRenderer implements ChatRenderer {

    @Override
    public @NotNull Component render(@NotNull Player source, @NotNull Component sourceDisplayName, @NotNull Component message, @NotNull Audience viewer) {
        var component = Component.text();
        component.append(sourceDisplayName.color(TextColor.color(0xc7ffff)));

        if (source.isOp())
            component.append(Component.text(" (관리자)", TextColor.color(0xffabb2)));

        component.append(Component.text(" : ", TextColor.color(0xd4d4d4)));
        component.append(message.color(TextColor.color(0xF1F1F1)));
        return component.build();
    }
}
