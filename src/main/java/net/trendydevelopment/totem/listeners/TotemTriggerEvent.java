package net.trendydevelopment.totem.listeners;

import net.trendydevelopment.totem.TotemCounter;
import net.trendydevelopment.totem.objects.TotemObject;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityResurrectEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class TotemTriggerEvent implements Listener {
    TotemCounter totem = JavaPlugin.getPlugin(TotemCounter.class);
    @EventHandler
    public void onResurection(EntityResurrectEvent e) {
        TotemObject totemObject = totem.getTotemMap().get(e.getEntity().getUniqueId());
        totemObject.addPlayer1Totem();
        totem.getTotemMap().get(totemObject.getPlayer2().getUniqueId()).addPlayer2Totem();
    }
}
