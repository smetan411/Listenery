package listenery.damage;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;

public class SekeraListener implements Listener {

    @EventHandler
    public void uderEndMecem(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        String vecVPraveRuce = player.getEquipment().getItemInMainHand().getItemMeta().getDisplayName();
        if (vecVPraveRuce.equals("Sekera")) {
            block.setType(Material.GOLD_BLOCK);
            event.setCancelled(true);
        }
    }
}


