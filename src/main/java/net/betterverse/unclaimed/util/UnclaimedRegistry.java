package net.betterverse.unclaimed.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.bukkit.Chunk;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class UnclaimedRegistry{

	private static List<ProtectionProvider> protections = new ArrayList<ProtectionProvider>();

	public static boolean registerClass(ProtectionProvider protection){
		return protections.add(protection);
	}

	public static boolean unregisterClass(ProtectionProvider protection){
		return protections.remove(protection);
	}

	public static List<ProtectionProvider> getProtections(){
		return Collections.unmodifiableList(protections);
	}

	public static void clearProtections(){
		protections.clear();
	}

	public static boolean isProtected(Chunk chunk){
		for(ProtectionProvider pp : protections){
			//System.out.println("[Debug] Checking plugin " + pp.getName() + " for protected status: " + pp.isProtected(chunk));
			if(pp.isProtected(chunk))
				return true;
		}

		return false;
	}

	public static boolean isProtected(Location loc){
		for(ProtectionProvider pp : protections){
			//System.out.println("[Debug] Checking plugin " + pp.getName() + " for protected status: " + pp.isProtected(loc));
			if(pp.isProtected(loc))
				return true;
		}

		return false;
	}

	public static boolean isProtectedFrom(Player player, Location loc){
		for(ProtectionProvider pp : protections){
			//System.out.println("[Debug] Checking plugin " + pp.getName() + " for protected status: " + pp.isProtectedFrom(player, loc));
			if(pp.isProtectedFrom(player, loc))
				return true;
		}

		return false;
	}

	public static boolean isProtectedFromNoWG(Player p, Location l){
		for(ProtectionProvider pp : protections){
			if(pp.getName().equalsIgnoreCase("WorldGuard"))
				continue;
			if(pp.isProtectedFrom(p, l))
				return true;
		}

		return false;
	}

	public static String getProtectedFromBy(Location loc, Player p){
		for(ProtectionProvider pp : protections){
			if(pp.isProtectedFrom(p, loc))
				return pp.getName();
		}

		return "";
	}

	public static String getProtectedBy(Location loc){
		for(ProtectionProvider pp : protections){
			if(pp.isProtected(loc))
				return pp.getName();
		}

		return "";
	}

	public static String getChunkProtectedBy(Chunk c){
		for(ProtectionProvider pp : protections){
			if(pp.isProtected(c))
				return pp.getName();
		}

		return "";
	}

	public static String getProtectedReason(Location loc){
		for(ProtectionProvider pp : protections){
			if(pp.isProtected(loc))
				return pp.getMessage(loc);
		}

		return "";
	}

	public static String getChunkProtectedReason(Chunk c){
		for(ProtectionProvider pp : protections){
			if(pp.isProtected(c))
				return pp.getMessage(c);
		}

		return "";
	}

}
