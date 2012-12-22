package net.betterverse.unclaimed.util;

public class ProtectionInfo {

    private String name;
    private String message;
    private Boolean isProtected;

    public static ProtectionInfo UNPROTECTED;

    static {
        UNPROTECTED = new ProtectionInfo();
    }

    public ProtectionInfo() {
        isProtected = Boolean.FALSE;
    }

    public ProtectionInfo(String name) {
        this.name = name;
        isProtected = Boolean.TRUE;
    }

    public ProtectionInfo(String name, String message) {
        this(name);
        this.message = message;
    }

    public Boolean isProtected() {
        return isProtected;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        if (isProtected) {
            StringBuilder string = new StringBuilder("is protected by ");
            string.append(name);
            if (message != null) {
                string.append(" (");
                string.append(message);
                string.append(")");
            }
            string.append(".");
            return string.toString();
        } else {
            return "is not protected.";
        }
    }
}
