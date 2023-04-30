package listenery.death;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class SmrtSpawn implements Listener {


    //platí pro pojmenovanou entitu, spawne se tam neco jineho
   @EventHandler
    public void smrtEntity(EntityDeathEvent smrt) {
        String jmenoZemreleEntity = smrt.getEntity().getCustomName(); //.getName()
        if (jmenoZemreleEntity.equals("Bystrouska")) {
            World svet = smrt.getEntity().getWorld();
            Location misto = smrt.getEntity().getLocation();
            svet.spawnEntity(misto.add(5,0,5), EntityType.WITHER_SKELETON);
            svet.spawnEntity(misto, EntityType.ENDER_CRYSTAL);
        }
    }
}
