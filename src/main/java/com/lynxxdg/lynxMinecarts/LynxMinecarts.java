package com.lynxxdg.lynxMinecarts;

import org.bukkit.plugin.java.JavaPlugin;

public final class LynxMinecarts extends JavaPlugin {
    @Override
    public void onEnable() {
        // Configuration stuff
        double defaultSpeed = getConfig().getDouble("default-speed", 8.0);
        double fastSpeed = getConfig().getDouble("fast-speed", 20.0);
        saveDefaultConfig();

        // Enable the event listeners
        getServer().getPluginManager().registerEvents(new EventHandler(defaultSpeed, fastSpeed), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
