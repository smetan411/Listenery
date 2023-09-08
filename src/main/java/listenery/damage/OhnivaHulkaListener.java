package listenery.damage;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.World;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class OhnivaHulkaListener implements Listener {

    @EventHandler
    public void strileniHulkou(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        if ((Action.RIGHT_CLICK_AIR.equals(event.getAction()) || Action.RIGHT_CLICK_BLOCK.equals(event.getAction()))) {
            if (item.getItemMeta().getLore().get(0).equals(ChatColor.DARK_PURPLE + "RIGHT-CLICK" + ChatColor.GREEN + " to shoot fire ball")) {
                World world = player.getWorld();
                player.launchProjectile(LargeFireball.class); // hrac vystreli projektil
                world.spawnParticle(Particle.SMOKE_LARGE, player.getLocation(), 80);
            }
        }
    }
}
