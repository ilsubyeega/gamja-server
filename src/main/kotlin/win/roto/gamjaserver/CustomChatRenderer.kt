package win.roto.gamjaserver

import io.papermc.paper.chat.ChatRenderer
import net.kyori.adventure.audience.Audience
import net.kyori.adventure.text.Component
import net.kyori.adventure.text.TextComponent
import net.kyori.adventure.text.format.TextColor.color
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.entity.Player

class CustomChatRenderer : ChatRenderer {
    override fun render(source: Player, sourceDisplayName: Component, message: Component, viewer: Audience): Component {
        return Component.text().apply {
            it.append(renderUsername(source, sourceDisplayName))
            it.append(Component.text(" : ", color(0xd4d4d4)))
            it.append(renderMessage(source, message))
        }.build()
    }

    private fun renderUsername(source: Player, sourceDisplayName: Component): Component {
        return Component.text().apply {
            it.append(sourceDisplayName.color(color(0xc7ffff)))

            if (source.isOp) it.append(Component.text(" (관리자)", color(0xffabb2)))
        }.build()
    }

    private fun renderMessage(source: Player, message: Component): Component {
        return Component.text().apply {
            if (source.isOp && message is TextComponent) {
                // FIXME: The component may have styles, but this one removes all of styles and getting plain text.
                it.append(MiniMessage.miniMessage().deserialize(message.content()))
            } else {
                it.append(message.color(color(0xF1F1F1)))
            }
        }.build()
    }
}