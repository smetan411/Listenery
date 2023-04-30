package listenery.move;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class ChuzeDiamant implements Listener {

    @EventHandler
    public void diamondMove(PlayerMoveEvent chuze) {
        ItemStack boty = chuze.getPlayer().getInventory().getBoots(); //ItemStack
        if (boty == null || boty.getItemMeta() == null) return;
        if (boty.getItemMeta().getDisplayName().equals("DiaBoty")) {
            Location polohaBot = chuze.getFrom();
            Location polohaBloku = polohaBot.add(0, -1, 0);
            Block aktualniBlok = chuze.getPlayer().getWorld().getBlockAt(polohaBloku);
            aktualniBlok.setType(Material.DIAMOND_BLOCK);
        }
    }
}
