package listenery.move;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class DiaBotyMizeni implements Listener {

    private final Plugin plugin;  // mizeni

    public DiaBotyMizeni(Plugin plugin) {
        this.plugin = plugin;
    }  // mizeni

    @EventHandler
    public void diamondMove(PlayerMoveEvent event) {

        ItemStack boty = event.getPlayer().getInventory().getBoots(); //ItemStack
        if (boty == null || boty.getItemMeta() == null) return;

        if (boty.getItemMeta().getDisplayName().equals("DiaBoty")) {
            Location polohaBot = event.getFrom();
            Location polohaBloku = polohaBot.add(0, -1, 0);
            Block aktualniBlok = event.getPlayer().getWorld().getBlockAt(polohaBloku);
            Material puvodniBlok = aktualniBlok.getType(); //mizeni
            if (aktualniBlok.getType().equals(Material.DIAMOND_BLOCK)) { //mizeni
                return;
            }
            aktualniBlok.setType(Material.DIAMOND_BLOCK);
            //mizeni casovac
            new BukkitRunnable() {
                @Override
                public void run() { aktualniBlok.setType(puvodniBlok);
                }
            }.runTaskLater(plugin, 40);
        }
    }
}
