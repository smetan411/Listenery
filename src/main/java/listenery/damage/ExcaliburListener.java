package listenery.damage;

import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ExcaliburListener implements Listener {

    @EventHandler
    public void uderExkalibrem(EntityDamageByEntityEvent event) {

        if (!(event.getDamager() instanceof Player)) return;
        Player player = (Player) event.getDamager();
        World svet = (World) player.getWorld();
        String vecVPraveRuce = player.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
        if ("Excalibur".equals(vecVPraveRuce)) {
            Entity entita = event.getEntity();
            entita.setFireTicks(100);
            svet.strikeLightning(entita.getLocation());
            if (entita instanceof LivingEntity) {
                LivingEntity zijciEntita = (LivingEntity) entita;
                zijciEntita.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 500, 10, true));
            }
        }
    }
}
