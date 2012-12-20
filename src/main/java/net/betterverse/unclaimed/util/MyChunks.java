package net.betterverse.unclaimed.util;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.Location;

public class MyChunks implements Protection {

    private net.betterverse.mychunks.bukkit.MyChunks plugin;

    public MyChunks() {
        plugin = (net.betterverse.mychunks.bukkit.MyChunks) Bukkit.getPluginManager().getPlugin("MyChunks");
    }

    @Override
    public String getName() {
        return "MyChunks";
    }

    /**
     * Checks if {@code chunk} is protected by {@link net.betterverse.mychunks.bukkit.MyChunks}
     * @param chunk chunk to check
     * @return true if contains protections, false if unprotected or plugin not found
     */
    @Override
    public boolean isProtected(Chunk chunk) {
        if (plugin == null) {
            return false;
        }
        return plugin.getChunkManager().isOwnedChunk(chunk.getWorld().getName(), chunk.getX(), chunk.getZ());
    }

    /**
     * Checks if {@code location} is protected by {@link net.betterverse.mychunks.bukkit.MyChunks}
     * @param location location to check
     * @return true if protected, false if unprotected or plugin not found
     */
    @Override
    public boolean isProtected(Location location) {
        if (plugin == null) {
            return false;
        }
        return plugin.getChunkManager().isOwnedChunk(location.getWorld().getName(), location.getChunk().getX(), location.getChunk().getZ());
    }
}
