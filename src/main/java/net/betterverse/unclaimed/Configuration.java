package net.betterverse.unclaimed;

import org.bukkit.configuration.file.YamlConfiguration;

public class Configuration {
    
    private int teleportCooldown;
    private int maxX;
    private int maxZ;
    private boolean hasWorldguard;
    private Unclaimed instance;
    
    private YamlConfiguration config;
    private static YamlConfiguration defaults;

    static {
        defaults = new YamlConfiguration();
        defaults.set("teleport-cooldown", 60);
        defaults.set("max-search-x", 5000);
        defaults.set("max-search-z", 5000);
        defaults.set("wrap-worldguard", false);
    }

    public Configuration(Unclaimed instance) {
        this.instance = instance;
        reload();
    }
    
    protected void reload() {
        config = (YamlConfiguration) instance.getConfig();
        config.setDefaults(defaults);
        teleportCooldown = config.getInt("teleport-cooldown");
        maxX = config.getInt("max-search-x");
        maxZ = config.getInt("max-search-z");
        hasWorldguard = config.getBoolean("wrap-worldguard");
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

    public Boolean hasWorldguard() {
        return hasWorldguard;
    }

}
