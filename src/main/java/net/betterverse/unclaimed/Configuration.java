package net.betterverse.unclaimed;

import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

public class Configuration {
    
    private int maxX;
    private int maxZ;
    private List<String> plugins;
    private Unclaimed instance;
    
    private YamlConfiguration config;

    private static YamlConfiguration defaults;

    static {
        defaults = new YamlConfiguration();
        defaults.set("max-search-x", 5000);
        defaults.set("max-search-z", 5000);
        defaults.set("plugins", new String[]{"Communities", "MyChunks", "WorldGuard"});
    }

    public Configuration(Unclaimed instance) {
        this.instance = instance;
        reload();
    }
    
    public void reload() {
        config = (YamlConfiguration) instance.getConfig();
        config.setDefaults(defaults);
        maxX = config.getInt("max-search-x");
        maxZ = config.getInt("max-search-z");
        plugins = config.getStringList("plugins");
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
