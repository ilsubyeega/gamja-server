package win.roto.gamjaserver.commands

import net.kyori.adventure.text.minimessage.MiniMessage
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import win.roto.gamjaserver.GamjaServer

class SetMOTDCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<String>): Boolean {
        if (!sender.isOp) return false
        if (args.isEmpty()) return false
        if (args[0].isEmpty()) return false

        try {
            GamjaServer.MOTD = MiniMessage.miniMessage().deserialize(args.joinToString(" "))
            sender.sendMessage("메세지를 성공적으로 변경했습니다.")
            sender.sendMessage(GamjaServer.MOTD)
        } catch (e: Exception) {
            sender.sendMessage("메세지를 변경하는데 실패했습니다: ${e.message}")
            e.printStackTrace()
        }

        return true
    }
}