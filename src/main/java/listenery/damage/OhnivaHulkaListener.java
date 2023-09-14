package listenery.damage;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
//lore je popisek
//player sneaking je hráč se plíží

public class OhnivaHulkaListener implements Listener {

    @EventHandler
    public void strileniHulkou(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();
        ItemStack hulka = event.getItem();
        if (hulka.getItemMeta().getLore().get(0).equals(ChatColor.DARK_PURPLE + "RIGHT-CLICK" + ChatColor.GREEN + " to shoot fire ball")) {
            if ((Action.RIGHT_CLICK_AIR.equals(event.getAction()) || Action.RIGHT_CLICK_BLOCK.equals(event.getAction()))) {
                if (player.isSneaking()) {
                    vytvoreniOhnivehoKruhu(event, 10, Material.FIRE);
                    vytvoreniOhnivehoKruhu(event, 9, Material.AIR);
                }

            } else {
                player.launchProjectile(LargeFireball.class); // hrac vystreli projektil
                world.spawnParticle(Particle.SMOKE_LARGE, player.getLocation(), 80);
            }
        }
    }

    private void vytvoreniOhnivehoKruhu(PlayerInteractEvent event, double polomer, Material material){
        Player player = event.getPlayer();
        World world = player.getWorld();
        Location location = player.getLocation();
        for (double x = location.getX() - polomer; x < location.getX() + polomer; x++) {
            for (double z = location.getZ() - polomer; z < location.getZ() + polomer; z++) {
                Location pozice = new Location(world, x, location.getY(), z);
                double xd = x - location.getX();
                double zd = z - location.getZ();
                double vzdalenost = Math.sqrt(xd * xd + zd * zd);
                if (vzdalenost < polomer) {
                    Block aktualniBlok = pozice.getBlock();
                    aktualniBlok.setType(material);
                }
            }
        }
    }
}

