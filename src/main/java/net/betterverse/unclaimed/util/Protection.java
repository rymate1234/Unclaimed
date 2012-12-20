package net.betterverse.unclaimed.util;

import org.bukkit.Chunk;
import org.bukkit.Location;

public interface Protection {

    public String getName();
    public boolean isProtected(Chunk chunk);
    public boolean isProtected(Location location);

}
