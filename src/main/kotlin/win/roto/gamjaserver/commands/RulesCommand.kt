package win.roto.gamjaserver.commands

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class RulesCommand : CommandExecutor {

    private val component: Component = MiniMessage.miniMessage().deserialize(
        """
        <b><color:#8d87ff>규칙:</color></b>
        <color:#d573ff> - 1: </color><color:#e3baff>엑스레이, 핵의 사용을 금지합니다.</color>
        <color:#d573ff> - 2: </color><color:#e3baff>비매너 채팅을 금지합니다.</color>
        <color:#d573ff> - 3: </color><color:#e3baff>모든 처벌은 차단(밴, ban)으로 이루어집니다.</color>
        <color:#d573ff> - 4: </color><color:#e3baff>랙을 유발하는 기계, 기술 등을 금지합니다.</color>
        <color:#d573ff> - </color><color:#ffc2d0>이외에는 관리자의 판단으로 이루어집니다.</color>
        <color:#cd9eff>서버 <u>재밌게</u> 즐겨주세요!</color>
        """.trimIndent()
    )

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        sender.sendMessage(component)
        return true
    }

}