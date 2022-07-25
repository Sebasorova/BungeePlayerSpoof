package me.sebasorovaa.BungeePlayerSpoof.events;

import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static me.sebasorovaa.BungeePlayerSpoof.Main.fakepla;

public class PingEvent implements Listener {
    public static int mincount = 1;
    public static int maxcount = 1;
    int changeit = 0;
    public void changeitfunc() {
        Random changerandom = new Random();
        int coinFlip2 = changerandom.nextInt(100);
        if (coinFlip2 >= 50) {
            changeit = 0;
        } else {
            changeit = 1;
        }
    }

    public void countchange() {
        Random random = new Random();
        int minimumRealisticNumber = -1;
        int coinFlip = random.nextInt(100);
        int countChange = ThreadLocalRandom.current().nextInt(mincount, maxcount + 1);
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
    public void onPing(ProxyPingEvent event) {
        changeitfunc();
        if (changeit == 0) {
            ServerPing ping = event.getResponse();
            ServerPing.Players current = ping.getPlayers();
            ping.setPlayers(new ServerPing.Players(current.getMax(), fakepla, current.getSample()));
            event.setResponse(ping);
        }
        else {
            countchange();
            ServerPing ping = event.getResponse();
            ServerPing.Players current = ping.getPlayers();
            ping.setPlayers(new ServerPing.Players(current.getMax(), fakepla, current.getSample()));
            event.setResponse(ping);
        }
    }
}
