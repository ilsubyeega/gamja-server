package roto.win.gamjaserver;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.plugin.java.JavaPlugin;
import roto.win.gamjaserver.commands.RulesCommand;
import roto.win.gamjaserver.commands.SetMotdCommand;
import roto.win.gamjaserver.listeners.ChatListener;
import roto.win.gamjaserver.listeners.JoinMessageListener;
import roto.win.gamjaserver.listeners.JoinQuitListener;
import roto.win.gamjaserver.listeners.PingListener;

public class GamjaServer extends JavaPlugin {

    private static GamjaServer instance;

    public static GamjaServer getInstance() {
        return instance;
    }

    public static Component motd = Component.text("현재 메시지가 없습니다.", TextColor.color(0xfff7cc));
    @Override
    public void onEnable() {
        instance = this;

        var pluginManager = getServer().getPluginManager();

        pluginManager.registerEvents(new PingListener(), this);
        pluginManager.registerEvents(new JoinMessageListener(), this);
        pluginManager.registerEvents(new JoinQuitListener(), this);
        pluginManager.registerEvents(new ChatListener(), this);

        getServer().getPluginCommand("rules").setExecutor(new RulesCommand());
        getServer().getPluginCommand("setmotd").setExecutor(new SetMotdCommand());
    }

    @Override
    public void onDisable() {
    }
}
