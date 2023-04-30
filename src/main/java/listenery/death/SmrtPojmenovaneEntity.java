package listenery.death;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class SmrtPojmenovaneEntity implements Listener {

    //platí pro pojmenovanou entitu, hrac ziska napr. perlu

    @EventHandler
    public void smrEntitySeJmenem(EntityDamageByEntityEvent smrt) {
        ItemStack perla = new ItemStack(Material.ENDER_PEARL, 10);
        String jmenoZemreleEntity = smrt.getEntity().getName();
        if (jmenoZemreleEntity.equals("DuhovaOvecka")) {
            Player hrac = (Player) smrt.getDamager();
            hrac.getInventory().addItem(perla);
        }
    }
}


