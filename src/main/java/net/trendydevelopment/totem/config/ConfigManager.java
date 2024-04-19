package net.trendydevelopment.totem.config;

import net.trendydevelopment.totem.TotemCounter;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {
    private final TotemCounter totemCounter;
    private final FileConfiguration config;
    public ConfigManager(TotemCounter totemCounter) {
        this.totemCounter = totemCounter;
        this.config = createConfig();
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public FileConfiguration createConfig() {
        File Messagefile = new File(totemCounter.getDataFolder(), "config.yml");

        if (!Messagefile.exists()) {
            Messagefile.getParentFile().mkdirs();
            totemCounter.saveResource("config.yml", false);
        }
        FileConfiguration message = new YamlConfiguration();
        try {
            message.load(Messagefile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return message;
    }
}
