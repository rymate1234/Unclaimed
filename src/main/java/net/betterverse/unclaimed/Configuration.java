package net.betterverse.unclaimed;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

public class Configuration {

    private String buildMessage;
    private int maxX;
    private int maxZ;
    private int teleportCooldown;
    private boolean wrapWorldguard;
    private List<String> activeRegenerationWorlds;
    private int regenerationOffset;
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
        List<String> defaultWorlds = new ArrayList<String>();
        defaults.set("regeneration-worlds", defaultWorlds);
        defaults.set("regeneration-interval", 12);
    }

    public Configuration(Unclaimed instance) {
        this.instance = instance;
        reload();
        try {
            config.save(new File(instance.getDataFolder(), "config.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    protected void reload() {
        config = (YamlConfiguration) instance.getConfig();
        config.setDefaults(defaults);
        buildMessage = config.getString("build-message");
        maxX = config.getInt("max-search-x");
        maxZ = config.getInt("max-search-z");
        teleportCooldown = config.getInt("teleport-cooldown");
        wrapWorldguard = config.getBoolean("wrap-worldguard");
        activeRegenerationWorlds = config.getStringList("regeneration-worlds");
        regenerationOffset = config.getInt("regeneration-interval");
        config.options().copyDefaults(true);
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
    
    public List<String> getActiveRegenerationWorlds() {
        return activeRegenerationWorlds;
    }
    
    public int getRegenerationOffset() {
        return regenerationOffset;
    }
}
