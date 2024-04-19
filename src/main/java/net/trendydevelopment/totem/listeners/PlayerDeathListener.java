package net.trendydevelopment.totem.listeners;

import net.trendydevelopment.totem.TotemCounter;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerDeathListener implements Listener {
    TotemCounter totem = JavaPlugin.getPlugin(TotemCounter.class);

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if (!totem.getTotemMap().containsKey(e.getEntity().getUniqueId())) return;
        totem.getTotemMap().remove(e.getEntity().getUniqueId());
    }
}
