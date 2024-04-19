package net.trendydevelopment.totem;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.trendydevelopment.totem.config.ConfigManager;
import net.trendydevelopment.totem.listeners.PlayerHitListener;
import net.trendydevelopment.totem.listeners.WorldChangeListener;
import net.trendydevelopment.totem.objects.TotemObject;
import net.trendydevelopment.totem.utils.ColourUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class TotemCounter extends JavaPlugin {
    FileConfiguration config;
    String layout;
    List<String> worlds;
    HashMap<UUID, TotemObject> totemMap;
    @Override
    public void onEnable() {
        this.config = new ConfigManager(this).getConfig();
        this.layout = ColourUtils.c(config.getString("layout"));
        this.worlds = config.getStringList("ignore-worlds");
        this.totemMap = new HashMap<>();
        startTimer();
        Bukkit.getPluginManager().registerEvents(new WorldChangeListener(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerHitListener(), this);
    }

    public void startTimer() {
        new BukkitRunnable() {
            @Override
            public void run() {
                totemMap.forEach((uuid, totemObject) -> {
                    totemObject.getPlayer1().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(layout.replace("{player1}", String.valueOf(totemObject.getPlayer1totems())).replace("{player2}", String.valueOf(totemObject.getPlayer2totems()))));
                });
            }
        }.runTaskTimerAsynchronously(this, 20*2, 20*2);
    }

    public List<String> getWorlds() {
        return worlds;
    }

    public HashMap<UUID, TotemObject> getTotemMap() {
        return totemMap;
    }
}
