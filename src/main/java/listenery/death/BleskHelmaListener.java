package listenery.death;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

import javax.annotation.Nullable;

//funguje při modu Survival
public class BleskHelmaListener implements Listener {

    @EventHandler
    public void blesk(EntityTargetLivingEntityEvent udalost) {
        Entity cil = udalost.getTarget();
        if (cil instanceof Player) {
            Player hrac = (Player) cil;
            if (vecNaHlave(hrac).equals("BleskovaHelma")) {
                Entity nepritel = udalost.getEntity();
                nepritel.getWorld().strikeLightning(nepritel.getLocation());
            }
        }
    }
    @Nullable
    private String vecNaHlave(Player hrac) {
        try {
            return hrac.getEquipment().getHelmet().getItemMeta().getDisplayName();
        } catch (NullPointerException e) {
            return null;
        }
    }
}


