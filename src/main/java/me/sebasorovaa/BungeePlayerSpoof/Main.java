package me.sebasorovaa.BungeePlayerSpoof;

// all commented imports are just for the config file thing, dont mind them :)
import me.sebasorovaa.BungeePlayerSpoof.commands.*;
import me.sebasorovaa.BungeePlayerSpoof.events.JoinDisconnectEvent;
import me.sebasorovaa.BungeePlayerSpoof.events.PingEvent;
import net.md_5.bungee.api.plugin.Plugin;
// import java.io.InputStream;
// import java.io.File;
// import java.io.IOException;
// import net.md_5.bungee.config.Configuration;
// import net.md_5.bungee.config.ConfigurationProvider;
// import net.md_5.bungee.config.YamlConfiguration;
// import java.io.OutputStream;
// import java.io.FileOutputStream;
// import com.google.common.io.ByteStreams;

public final class Main extends Plugin {
    public static int fakepla = 4;
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

        getProxy().getPluginManager().registerCommand(this, new AddPlayer());
        getProxy().getPluginManager().registerCommand(this, new RemovePlayer());
        getProxy().getPluginManager().registerCommand(this, new SetPlayer());
        getProxy().getPluginManager().registerCommand(this, new DropPlayers());
        getProxy().getPluginManager().registerCommand(this, new SetPlayerRange());
        getProxy().getPluginManager().registerCommand(this, new AddPlayers());
        getProxy().getPluginManager().registerListener(this, new JoinDisconnectEvent());
        getProxy().getPluginManager().registerListener(this, new PingEvent());
        
        getLogger().info("PlayerSpoofer loaded");
    }




    @Override
    public void onDisable() {
        getLogger().info("PlayerSpoofer unloaded");
    }
}

