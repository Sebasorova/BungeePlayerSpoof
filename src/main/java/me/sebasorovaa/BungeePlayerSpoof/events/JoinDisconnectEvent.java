package me.sebasorovaa.BungeePlayerSpoof.events;

import me.sebasorovaa.BungeePlayerSpoof.Main;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class JoinDisconnectEvent implements Listener {

    @EventHandler
    public void onConnect(ServerConnectEvent event){
        Main.fakepla++;
    }

    @EventHandler
    public void onDisconnect(ServerDisconnectEvent event){
        Main.fakepla--;
    }
}
