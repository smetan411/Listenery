package listenery.move;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class DiaBotyListener implements Listener {

    @EventHandler
    public void diamondMove(PlayerMoveEvent event) {

        ItemStack boty = event.getPlayer().getInventory().getBoots(); //ItemStack
        if (boty == null || boty.getItemMeta() == null) return;

        if (boty.getItemMeta().getDisplayName().equals("DiaBoty")) {
            Location polohaBot = event.getFrom();
            Location polohaBloku = polohaBot.add(0, -1, 0);
            Block aktualniBlok = event.getPlayer().getWorld().getBlockAt(polohaBloku);
            aktualniBlok.setType(Material.DIAMOND_BLOCK);
        }
    }
}
