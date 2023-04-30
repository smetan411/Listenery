package listenery.damage;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class MotykaListener implements Listener {

    @EventHandler
    public void uderMotykou(EntityDamageByEntityEvent uder) {
        if (!(uder.getDamager() instanceof LivingEntity)) return;
        LivingEntity utocnik = (LivingEntity) uder.getDamager();
        String nazevVeci = utocnik.getEquipment().getItemInMainHand().getItemMeta().getDisplayName();
        if (nazevVeci.equals("Motyka")) {
            Entity obet = uder.getEntity();
            obet.teleport(obet.getLocation().add(0, -3, 0));
        }
    }
}
