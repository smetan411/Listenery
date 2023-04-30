package listenery.damage;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EndMecListener implements Listener {

    @EventHandler
    public void uderEndMecem(EntityDamageByEntityEvent event) {
        Entity entity = event.getDamager();
        if (!(entity instanceof LivingEntity)) return;
        LivingEntity livingEntity = (LivingEntity) entity;

        String vecVPraveRuce = livingEntity.getEquipment().getItemInMainHand().getItemMeta().getDisplayName();
        if (vecVPraveRuce.equals("EndMec")) {
            Entity victim = event.getEntity();
            if (victim instanceof LivingEntity) {
                LivingEntity victimLivingEntity = (LivingEntity) victim;
                victimLivingEntity.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1000000, 10, true));
                victimLivingEntity.getLocation().add(0, 100, 0);
            }
        }
    }
}

