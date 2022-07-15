package me.sebasorovaa.BungeePlayerSpoof.commands;

import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.ChatColor;
import static me.sebasorovaa.BungeePlayerSpoof.Main.fakepla;

public class AddPlayer extends Command {
    public AddPlayer() {
        super("addPlayer");
    }
    public void execute(CommandSender sender, String[] args) {
        fakepla++;
        sender.sendMessage(ChatColor.RED + "[BungeePlayerSpoof] " + ChatColor.GREEN + "Added 1 Player");
    }
}
