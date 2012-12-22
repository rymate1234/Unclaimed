package net.betterverse.unclaimed.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnclaimedRegistry {

    private static List<Protection> protections;

    static {
        protections = new ArrayList<Protection>();
    }

    public static boolean registerClass(Protection protection) {
        return protections.add(protection);
    }

    public static boolean unregisterClass(Protection protection) {
        return protections.remove(protection);
    }

    public static List<Protection> getProtections() {
        return Collections.unmodifiableList(protections);
    }

    public static void clearProtections() {
        protections.clear();
    }

}
