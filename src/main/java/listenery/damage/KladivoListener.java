package listenery.damage;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import java.util.List;

public class KladivoListener implements Listener {
    @EventHandler
    public void uhozeni (EntityDamageByEntityEvent event) {
        Entity cil = event.getDamager();
        if(cil instanceof Player){
            Player hrac = (Player) cil;
            String vecmeta = hrac.getInventory().getItemInMainHand().getItemMeta().getDisplayName();
            if ("Kladivo".equals(vecmeta)){
                Entity utoceny = event.getEntity();
                World svet = utoceny.getWorld();
                svet.playSound(utoceny.getLocation(), Sound.BLOCK_ANVIL_LAND, 1,(float) 0.7);
                utoceny.teleport(utoceny.getLocation().add(0,-1.5,0));
                List<Entity> nearbyEntities = (List<Entity>) svet.getNearbyEntities(utoceny.getLocation(), 5, 5, 5);
                for(Entity e : svet.getEntities()){
                    if(nearbyEntities.contains(e)){
                        if(!(e instanceof Player) && !(e.equals(utoceny))){
                            Location sub = e.getLocation().subtract(utoceny.getLocation());
                            Vector subve = sub.toVector().normalize().multiply(2);
                            //Vector finalvec = subve.add(new Vector(0,1,0));
                            e.setVelocity(subve);
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void bouchnuti (BlockDamageEvent blocke){
        Player hrac = blocke.getPlayer();
        Block blok = blocke.getBlock();

        if(blocke.getItemInHand().getItemMeta() != null){
            String vecmeta = blocke.getItemInHand().getItemMeta().getDisplayName();
            if ("Kladivo".equals(vecmeta)){
                World svet = hrac.getWorld();
                svet.playSound(blok.getLocation(), Sound.BLOCK_ANVIL_LAND, 1,(float) 0.7);
                Location lokacebloku = blok.getLocation();
                List<Entity> nearbyEntities = (List<Entity>) svet.getNearbyEntities(blok.getLocation(), 5, 5, 5);
                for(Entity e : svet.getEntities()){
                    if(nearbyEntities.contains(e)){
                        if(!(e instanceof Player)){
                            Location sub = e.getLocation().subtract(lokacebloku);
                            Vector subve = sub.toVector().normalize().multiply(2);
                            //Vector finalvec = subve.add(new Vector(0,1,0));
                            e.setVelocity(subve);
                        }
                    }
                }
            }
        }
    }
}
