package win.roto.gamjaserver

import net.kyori.adventure.text.Component
import net.kyori.adventure.text.format.TextColor
import org.bukkit.plugin.java.JavaPlugin
import win.roto.gamjaserver.commands.RulesCommand
import win.roto.gamjaserver.commands.SetMOTDCommand
import win.roto.gamjaserver.listeners.ChatListener
import win.roto.gamjaserver.listeners.JoinMessageListener
import win.roto.gamjaserver.listeners.JoinQuitListener
import win.roto.gamjaserver.listeners.PingListener

class GamjaServer : JavaPlugin() {

    companion object {
        lateinit var instance: GamjaServer
        var MOTD : Component = Component.text("현재 메시지가 없습니다.", TextColor.color(0xfff7cc))
    }

    override fun onEnable() {
        instance = this

        val pluginManager = server.pluginManager
        pluginManager.registerEvents(PingListener(), this)
        pluginManager.registerEvents(JoinMessageListener(), this)
        pluginManager.registerEvents(JoinQuitListener(), this)
        pluginManager.registerEvents(ChatListener(), this)

        server.getPluginCommand("rules")?.setExecutor(RulesCommand())
        server.getPluginCommand("setmotd")?.setExecutor(SetMOTDCommand())
    }
}