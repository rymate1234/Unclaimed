package net.betterverse.unclaimed;

import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

public class Configuration {
    
    private int teleportCooldown;
    private int maxX;
    private int maxZ;
    private List<String> plugins;
    private Unclaimed instance;
    
    private YamlConfiguration config;

    private static YamlConfiguration defaults;

    static {
        defaults = new YamlConfiguration();
        defaults.set("teleport-cooldown", 60);
        defaults.set("max-search-x", 5000);
        defaults.set("max-search-z", 5000);
        defaults.set("plugins", new String[]{"WorldGuard"});
    }

    public Configuration(Unclaimed instance) {
        this.instance = instance;
        reload();
    }
    
    public void reload() {
        config = (YamlConfiguration) instance.getConfig();
        config.setDefaults(defaults);
        teleportCooldown = config.getInt("teleport-cooldown");
        maxX = config.getInt("max-search-x");
        maxZ = config.getInt("max-search-z");
        plugins = config.getStringList("plugins");
    }

    public int getTeleportCooldown() {
        return teleportCooldown;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxZ() {
        return maxZ;
    }

    public List<String> getPlugins() {
        return plugins;
    }
}
