/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  org.bukkit.configuration.file.YamlConfiguration
 */
package ru.BossWars.loadConfig;

import java.io.IOException;
import ru.BossWars.main.BossWars;

public class saveConfig {
    public static void saveConfigs() {
        if (!BossWars.lbs.exists() | BossWars.pos != null | !BossWars.lbs.equals("Locations.lobby.world") | !BossWars.lbs.equals("Locations.lobby.x") | !BossWars.lbs.equals("Locations.lobby.y") | !BossWars.lbs.equals("Locations.lobby.z")) {
            try {
                BossWars.lbs.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            if (BossWars.pos != null) {
                BossWars.lb.set("Locations.lobby.world", BossWars.pos.worldName);
                BossWars.lb.set("Locations.lobby.x", BossWars.pos.x);
                BossWars.lb.set("Locations.lobby.y", BossWars.pos.y);
                BossWars.lb.set("Locations.lobby.z", BossWars.pos.z);
            } else {
                BossWars.lb.set("Locations.lobby.world", "world");
                BossWars.lb.set("Locations.lobby.x", -150);
                BossWars.lb.set("Locations.lobby.y", 64);
                BossWars.lb.set("Locations.lobby.z", 180);
            }
            try {
                BossWars.lb.save(BossWars.lbs);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

