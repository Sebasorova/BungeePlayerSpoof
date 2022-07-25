package me.sebasorovaa.BungeePlayerSpoof.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import static me.sebasorovaa.BungeePlayerSpoof.Main.fakepla;

public class DropPlayers extends Command {
    public DropPlayers() {
        super("setplayers");
    }
    public void execute(CommandSender sender, String[] args) {
            try {
                fakepla = 0;
                sender.sendMessage(ChatColor.RED + "[BungeePlayerSpoof] " + ChatColor.GREEN + "Successfully reseted the PlayerCount");
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
}