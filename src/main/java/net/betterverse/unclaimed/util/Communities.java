package net.betterverse.unclaimed.util;

import net.betterverse.communities.community.WorldCoord;
import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;

public class Communities implements Protection {

    private net.betterverse.communities.Communities plugin;

    public Communities() {
        plugin = (net.betterverse.communities.Communities) Bukkit.getPluginManager().getPlugin("Communities");
    }

    @Override
    public String getName() {
        return "Communities";
    }

    /**
     * Checks if {@code chunk} is protected by {@link net.betterverse.communities.Communities}
     * @param chunk chunk to check
     * @return true if contains protections, false if unprotected or plugin not found
     */
    public boolean isProtected(Chunk chunk) {
        if (plugin == null) {
            return false;
        }
        return plugin.isChunkOwned(new WorldCoord(chunk.getWorld().getName(), chunk.getX(), chunk.getZ()));
    }

    /**
     * Checks if {@code location} is protected by {@link net.betterverse.communities.Communities}
     * @param location location to check
     * @return true if protected, false if unprotected or plugin not found
     */
    public boolean isProtected(Location location) {
        if (plugin == null) {
            return false;
        }
        return plugin.isChunkOwned(new WorldCoord(location.getWorld().getName(), location.getChunk().getX(), location.getChunk().getZ()));
    }

}
