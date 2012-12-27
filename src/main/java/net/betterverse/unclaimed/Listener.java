package net.betterverse.unclaimed;

import net.betterverse.unclaimed.util.CheckProtection;
import net.betterverse.unclaimed.util.ProtectionInfo;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockCanBuildEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.hanging.HangingBreakByEntityEvent;
import org.bukkit.event.hanging.HangingPlaceEvent;
import org.bukkit.event.player.PlayerBucketEmptyEvent;
import org.bukkit.event.player.PlayerBucketEvent;
import org.bukkit.event.player.PlayerBucketFillEvent;


public class Listener implements org.bukkit.event.Listener {

    private Unclaimed instance;

    public Listener(Unclaimed instance) {
        this.instance = instance;
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        ProtectionInfo protectionInfo = CheckProtection.isProtected(player.getLocation());
        if (!protectionInfo.isProtected() && !player.hasPermission("unclaimed.break")) {
            event.setCancelled(true);
            player.sendMessage(instance.getDescription().getPrefix() + instance.getConfiguration().getBuildMessage());
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        ProtectionInfo protectionInfo = CheckProtection.isProtected(player.getLocation());
        if (!protectionInfo.isProtected() && !player.hasPermission("unclaimed.break")) {
            event.setCancelled(true);
            player.sendMessage(instance.getDescription().getPrefix() + instance.getConfiguration().getBuildMessage());
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onPlayerBucket(PlayerBucketEmptyEvent event) {
        Player player = event.getPlayer();
        ProtectionInfo protectionInfo = CheckProtection.isProtected(player.getLocation());
        if (!protectionInfo.isProtected() && !player.hasPermission("unclaimed.break")) {
            event.setCancelled(true);
            player.sendMessage(instance.getDescription().getPrefix() + instance.getConfiguration().getBuildMessage());
        }
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onPlayerBucket(PlayerBucketFillEvent event) {
        Player player = event.getPlayer();
        ProtectionInfo protectionInfo = CheckProtection.isProtected(player.getLocation());
        if (!protectionInfo.isProtected() && !player.hasPermission("unclaimed.break")) {
            event.setCancelled(true);
            player.sendMessage(instance.getDescription().getPrefix() + instance.getConfiguration().getBuildMessage());
        }
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onHangingBreakByEntity(HangingBreakByEntityEvent e) {
        if (e.getRemover() instanceof Player) {
            Player player = (Player)e.getRemover();
            ProtectionInfo protectionInfo = CheckProtection.isProtected(player.getLocation());
            if (!protectionInfo.isProtected() && !player.hasPermission("unclaimed.break")) {
                e.setCancelled(true);
                player.sendMessage(instance.getDescription().getPrefix() + instance.getConfiguration().getBuildMessage());
            }
        }
    }
    
    @EventHandler(ignoreCancelled = true)
    public void onHangingPlace(HangingPlaceEvent e) {
        Player player = e.getPlayer();
        ProtectionInfo protectionInfo = CheckProtection.isProtected(player.getLocation());
        if (!protectionInfo.isProtected() && !player.hasPermission("unclaimed.break")) {
            e.setCancelled(true);
            player.sendMessage(instance.getDescription().getPrefix() + instance.getConfiguration().getBuildMessage());
        }
    }
}
