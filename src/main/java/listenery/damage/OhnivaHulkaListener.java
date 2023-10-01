package listenery.damage;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.LargeFireball;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;
//lore je popisek
//player sneaking je hráč se plíží, držíme shift

public final class OhnivaHulkaListener implements Listener {
    private int taskId;
    private final BukkitScheduler scheduler = Bukkit.getScheduler();
    private int taskRunCounter = 0;
    private int velikostKruhu = 10;
    private Plugin plugin;

    public OhnivaHulkaListener(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void strileniHulkou(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        World world = player.getWorld();
        ItemStack hulka = event.getItem();
        if (hulka == null) return;

        if ((ChatColor.DARK_PURPLE + "RIGHT-CLICK" + ChatColor.GREEN + " to shoot fire ball").equals(hulka.getItemMeta().getLore().get(0))) {
            if ((Action.RIGHT_CLICK_AIR.equals(event.getAction()) || Action.RIGHT_CLICK_BLOCK.equals(event.getAction()))) {
                if (player.isSneaking()) {
                    velikostKruhu = 10;
                    taskRunCounter = 0;
                    taskId = scheduler.scheduleSyncRepeatingTask(plugin, new ZapalKruh(player.getLocation(), player.getWorld(), 10),0, 100);
                }
            } else {
                player.launchProjectile(LargeFireball.class); // hrac vystreli projektil
                world.spawnParticle(Particle.SMOKE_LARGE, player.getLocation(), 80);
            }
        }
    }

    private class ZapalKruh implements Runnable {

        private Location location;
        private World world;
        private int pocetKroku;

        public ZapalKruh(Location location, World world, int pocetKroku) {
            this.location = location;
            this.world = world;
            this.pocetKroku = pocetKroku;
        }

        @Override
        public void run() {
            if (++taskRunCounter >= pocetKroku) {
                scheduler.cancelTask(taskId);
                Bukkit.getLogger().info("scheduler canceled");
            }
            velikostKruhu += 2;
            vytvoreniOhnivehoKruhu(location, world, velikostKruhu, Material.FIRE);
            Bukkit.getLogger().info("velikost kruhu :" + velikostKruhu);
            mazaniOhnivehoKruhu(location, world, velikostKruhu-1, Material.AIR);
        }

        private void vytvoreniOhnivehoKruhu(Location location, World world, double polomer, Material material) {
            for (double x = location.getX() - polomer; x < location.getX() + polomer; x++) {
                for (double z = location.getZ() - polomer; z < location.getZ() + polomer; z++) {
                    Location pozice = new Location(world, x, location.getY(), z);
                    double xd = x - location.getX();
                    double zd = z - location.getZ();
                    double vzdalenost = Math.sqrt(xd * xd + zd * zd);
                    if ((vzdalenost < polomer+1)&&(vzdalenost > polomer-1)) {
                        Block aktualniBlok = pozice.getBlock();
                        aktualniBlok.setType(material);
                    }
                }
            }
        }

        private void mazaniOhnivehoKruhu(Location location, World world, double polomer, Material material) {
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

}

