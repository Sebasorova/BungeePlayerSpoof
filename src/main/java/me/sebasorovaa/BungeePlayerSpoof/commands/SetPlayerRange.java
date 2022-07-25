package me.sebasorovaa.BungeePlayerSpoof.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.plugin.Command;
import static me.sebasorovaa.BungeePlayerSpoof.events.PingEvent.maxcount;
import static me.sebasorovaa.BungeePlayerSpoof.events.PingEvent.mincount;

public class SetPlayerRange extends Command {
    public SetPlayerRange() {
        super("setplayerrange");
    }
    public void execute(CommandSender sender, String[] args) {
        if (args.length != 2){
            sender.sendMessage(ChatColor.RED + "[BungeePlayerSpoof] " + ChatColor.RED + "Correct usage: /setplayerrange <minimum> <maximum>");
            ;
        } else {
            try {
                maxcount = Integer.parseInt(args[0]);
                mincount = Integer.parseInt(args[1]);
                sender.sendMessage(ChatColor.RED + "[BungeePlayerSpoof] " + ChatColor.GREEN + "Successfully set the minimum range to " + args[0] + " and the maximum to " + args[1] + " Players");
            } catch (NumberFormatException e) {
                e.printStackTrace();
                sender.sendMessage(ChatColor.RED + "[BungeePlayerSpoof] " + ChatColor.RED + "You must type a number");
            }
        }
    }
}
