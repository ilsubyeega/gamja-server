package roto.win.gamjaserver.commands;

import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import roto.win.gamjaserver.GamjaServer;

public class SetMotdCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.isOp()) return false;
        if (args.length == 0) return false;
        if (args[0].length() < 1) return false;

        try {
            GamjaServer.motd = MiniMessage.miniMessage().deserialize(String.join(" ", args));
            sender.sendMessage("메시지를 설정하였습니다:");
            sender.sendMessage(GamjaServer.motd);
        } catch (Exception e) {
            sender.sendMessage("오류");
            sender.sendMessage(e.getMessage());
            e.printStackTrace();
        }

        return true;
    }
}
