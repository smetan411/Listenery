package listenery.death;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

//platí pro jakoukoliv entitu zabitou hráčem

public class Drops implements Listener {
    @EventHandler
    public void smrtEntity(EntityDeathEvent smrt) {
        ItemStack perla = new ItemStack(Material.ENDER_PEARL, 16);
        ItemStack jablko = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 64);
        Entity killer = smrt.getEntity().getKiller();

        if (killer instanceof Player) {
            smrt.getDrops().clear();
            smrt.getDrops().add(perla);
            smrt.getDrops().add(jablko);
        }
    }
}
