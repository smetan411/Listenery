package listenery.damage;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class MagickaHulkaListener implements Listener {

    @EventHandler
    public void magickaHulka(EntityDamageByEntityEvent udalost) {
        Entity obet = udalost.getEntity();
        Player utocnik = (Player) udalost.getDamager();
        String vecVPraveRuce = utocnik.getInventory().getItemInMainHand().getItemMeta().getDisplayName();

        if (utocnik instanceof Player) {
            if ("MagickaHulka".equals(vecVPraveRuce)) {
                if (obet instanceof LivingEntity) {
                    ((LivingEntity) obet).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 10000, 2, true, true, true));//icon - v inventari
                    ((LivingEntity) obet).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 2000, 2, true, true, true));
                }
            }
        }
    }
}
