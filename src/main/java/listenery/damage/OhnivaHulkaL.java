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

public final class OhnivaHulkaL implements Listener {
    private final BukkitScheduler scheduler = Bukkit.getScheduler();
    private Plugin plugin;

    public OhnivaHulkaL(Plugin plugin) {
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
                    OhnivyKruhTask ohnivyKruh = new OhnivyKruhTask(player.getLocation(), player.getWorld());
                    int taskId = scheduler.scheduleSyncRepeatingTask(plugin, ohnivyKruh,0, 10);
                    ohnivyKruh.setTaskId(taskId);
                }
            } else {
                player.launchProjectile(LargeFireball.class); // hrac vystreli projektil
                world.spawnParticle(Particle.SMOKE, player.getLocation(), 80);
            }
        }
    }

    private class OhnivyKruhTask implements Runnable {

        private static final int MAX_SIZE = 20;
        private static final int MIN_SIZE = 3;
        private int taskId;
        private Location location;
        private World world;
        private int velikostKruhu;

        public OhnivyKruhTask(Location location, World world) {
            this.location = location;
            this.world = world;
            velikostKruhu = MIN_SIZE;
        }

        public void setTaskId(int taskId) {
            this.taskId = taskId;
        }

        @Override
        public void run() {
            if (velikostKruhu >= MAX_SIZE) {
                scheduler.cancelTask(taskId);
                Bukkit.getLogger().info("scheduler canceled");
            }
            vytvoreniOhnivehoKruhu(location, world, velikostKruhu, Material.FIRE);
            Bukkit.getLogger().info("velikost kruhu :" + velikostKruhu);
            mazaniOhnivehoKruhu(location, world, velikostKruhu-1, Material.AIR);
            velikostKruhu++;
        }

        private void vytvoreniOhnivehoKruhu(Location location, World world, double polomer, Material material) {
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

