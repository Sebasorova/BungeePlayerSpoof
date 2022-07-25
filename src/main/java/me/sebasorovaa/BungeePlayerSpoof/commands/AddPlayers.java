package me.sebasorovaa.BungeePlayerSpoof.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import static me.sebasorovaa.BungeePlayerSpoof.Main.fakepla;

public class AddPlayers extends Command {
    public AddPlayers() {
        super("addplayers");
    }
    public void execute(CommandSender sender, String[] args) {
        if (args.length == 0){
            sender.sendMessage(ChatColor.RED + "[BungeePlayerSpoof] " + ChatColor.RED + "Correct usage: /addplayers <number>");
            ;
        } else {
            try {
                int addingpl = Integer.parseInt(args[0]);
                fakepla = fakepla + addingpl;
                sender.sendMessage(ChatColor.RED + "[BungeePlayerSpoof] " + ChatColor.GREEN + "Successfully added" + args[0] + " Players");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                sender.sendMessage(ChatColor.RED + "[BungeePlayerSpoof] " + ChatColor.RED + "You need to type a number");
            }
        }
    }
}
