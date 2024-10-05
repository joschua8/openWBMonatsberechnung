package com.example.openWBLadelog;

public class DirectoryHelper {

    public static String getDownloadDirectory() {
        String home = System.getProperty("user.home");
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            // Auf Windows ist es in der Regel im Verzeichnis "Downloads"
            return home + "\\Downloads\\";
        } else if (os.contains("mac")) {
            // Auf Mac ist es ebenfalls im Verzeichnis "Downloads"
            return home + "/Downloads/";
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            // Auf Linux-basierten Systemen (inklusive UNIX) ist es ebenfalls im Verzeichnis "Downloads"
            return home + "/Downloads/";
        } else {
            // Fallback für unbekannte Systeme
            throw new UnsupportedOperationException("Betriebssystem nicht unterstützt: " + os);
        }
    }
}
