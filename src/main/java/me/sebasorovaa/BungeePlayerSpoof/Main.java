package me.sebasorovaa.BungeePlayerSpoof;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.api.plugin.Listener;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class Main extends Plugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("PlayerSpoofer loaded");
        getProxy().getPluginManager().registerListener(this, this);
    }

    public void countchange() {
        Random random = new Random();
        int minimumRealisticNumber = -1;
        int coinFlip = random.nextInt(100);
        int fakepla = 14;
        int countChange = ThreadLocalRandom.current().nextInt(1, 1 + 1);
        if (coinFlip >= 50){
            fakepla = fakepla + countChange;
        } else {
            fakepla = fakepla - countChange;
        }
        if (fakepla < minimumRealisticNumber){
            fakepla = minimumRealisticNumber;
        }

        if (fakepla < 1) {
            fakepla = 2;
        }
    }

    @EventHandler
    public void onPing(ProxyPingEvent event)
    {
            countchange();
            ServerPing ping = event.getResponse();
            ServerPing.Players current = ping.getPlayers();
            ping.setPlayers( new ServerPing.Players( current.getMax(), countchange, current.getSample() ) );
            event.setResponse( ping );
    }

    @Override
    public void onDisable() {
        getLogger().info("PlayerSpoofer unloaded");
    }
}
