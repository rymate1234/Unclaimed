package net.betterverse.unclaimed;

import org.bukkit.configuration.file.YamlConfiguration;

public class Configuration {

    private String buildMessage;
    private int maxX;
    private int maxZ;
    private int teleportCooldown;
    private boolean wrapWorldguard;
    private Unclaimed instance;
    
    private YamlConfiguration config;
    private static YamlConfiguration defaults;

    static {
        defaults = new YamlConfiguration();
        defaults.set("build-message", "You do not have permission to build here.");
        defaults.set("max-search-x", 5000);
        defaults.set("max-search-z", 5000);
        defaults.set("teleport-cooldown", 60);
        defaults.set("wrap-worldguard", false);
    }

    public Configuration(Unclaimed instance) {
        this.instance = instance;
        reload();
    }
    
    protected void reload() {
        config = (YamlConfiguration) instance.getConfig();
        config.setDefaults(defaults);
        buildMessage = config.getString("build-message");
        maxX = config.getInt("max-search-x");
        maxZ = config.getInt("max-search-z");
        teleportCooldown = config.getInt("teleport-cooldown");
        wrapWorldguard = config.getBoolean("wrap-worldguard");
    }

    public String getBuildMessage() {
        return buildMessage;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxZ() {
        return maxZ;
    }

    public int getTeleportCooldown() {
        return teleportCooldown;
    }

    public Boolean wrapWorldguard() {
        return wrapWorldguard;
    }
}
