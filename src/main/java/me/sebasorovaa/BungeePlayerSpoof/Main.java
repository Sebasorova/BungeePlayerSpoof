package me.sebasorovaa.BungeePlayerSpoof;

// all commented imports are just for the config file thing, dont mind them :)
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.api.plugin.Listener;
// import java.io.InputStream;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
// import java.io.File;
// import java.io.IOException;
// import net.md_5.bungee.config.Configuration;
// import net.md_5.bungee.config.ConfigurationProvider;
// import net.md_5.bungee.config.YamlConfiguration;
// import java.io.OutputStream;
// import java.io.FileOutputStream;
// import com.google.common.io.ByteStreams;

public final class Main extends Plugin implements Listener {
    int fakepla = 4;
    int changeit = 0;
    @Override
    public void onEnable() {
        // This is a test for the config file, in development
        //
        // Configuration configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        // ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, new File(getDataFolder(), "config.yml"));
        // if (!getDataFolder().exists()) {
        //     getDataFolder().mkdir();
        // }
        // File configFile = new File(getDataFolder(), "config.yml");
        // if (!configFile.exists()) {
        //     try {
        //         configFile.createNewFile();
        //         try (InputStream is = getResourceAsStream("config.yml");
        //              OutputStream os = new FileOutputStream(configFile)) {
        //            ByteStreams.copy(is, os);
        //         }
        //     } catch (IOException e) {
        //         throw new RuntimeException("Unable to create configuration file", e);
        //     }
        // }

        getLogger().info("PlayerSpoofer loaded");
        getProxy().getPluginManager().registerListener(this, this);
    }

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

    @Override
    public void onDisable() {
        getLogger().info("PlayerSpoofer unloaded");
    }
}
