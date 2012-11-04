package net.betterverse.unclaimed;

import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
    
    public int maxX = 5000;
    public int maxZ = 5000;
    
    private YamlConfiguration config;
    
    public Config(Main instance) {
        config = (YamlConfiguration)instance.getConfig();
        
        if (config.isInt("max-search-x")) maxX = config.getInt("max-search-x");
        else config.set("max-search-x", 5000);
        
        if (config.isInt("max-search-z")) maxZ = config.getInt("max-search-z");
        else config.set("max-search-z", 5000);
        
        instance.saveConfig();
    }
    
    public void reload(Main instance) {
        instance.reloadConfig();
        maxX = config.getInt("max-search-x");
        maxZ = config.getInt("max-search-z");
    }

}
