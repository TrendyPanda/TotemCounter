package net.trendydevelopment.totem.listeners;

import net.trendydevelopment.totem.TotemCounter;
import net.trendydevelopment.totem.objects.TotemObject;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class PlayerHitListener implements Listener {
    TotemCounter totem = JavaPlugin.getPlugin(TotemCounter.class);
    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent e) {
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
            if (totem.getTotemMap().containsKey(e.getDamager().getUniqueId())) return;
            totem.getTotemMap().put(e.getDamager().getUniqueId(),new TotemObject((Player) e.getDamager(), (Player) e.getEntity(), 0, 0));
        }
    }
}
