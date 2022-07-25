package me.sebasorovaa.BungeePlayerSpoof.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import static me.sebasorovaa.BungeePlayerSpoof.Main.fakepla;

public class RemovePlayers extends Command {
    public RemovePlayers() {
        super("removeplayers");
    }
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0){
            sender.sendMessage(ChatColor.RED + "[BungeePlayerSpoof] " + ChatColor.RED + "Correct usage: /removeplayers <number>");
            ;
        } else {
            try {
                int subbspl = Integer.parseInt(args[0]);
                fakepla = fakepla - subbspl;
                sender.sendMessage(ChatColor.RED + "[BungeePlayerSpoof] " + ChatColor.GREEN + "Successfully Removed " + args[0] + " Players");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                sender.sendMessage(ChatColor.RED + "[BungeePlayerSpoof] " + ChatColor.RED + "You must type a number");
            }
        }
    }
}