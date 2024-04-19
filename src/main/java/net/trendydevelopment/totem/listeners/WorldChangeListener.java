package net.trendydevelopment.totem.listeners;

import net.trendydevelopment.totem.TotemCounter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class WorldChangeListener implements Listener {
    TotemCounter totem = JavaPlugin.getPlugin(TotemCounter.class);
    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent e) {
        if (totem.getWorlds().contains(e.getFrom().getName())) return;
        totem.getTotemMap().remove(e.getPlayer().getUniqueId());
    }

}
