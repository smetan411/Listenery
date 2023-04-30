package listenery.veci;

import listenery.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Fox;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class LiskaBystrouska extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        Fox liska = world.spawn(playerLocation, Fox.class);
        liska.setCustomName("Bystrouska");
        liska.setCustomNameVisible(true);
        liska.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 999999999, 3));
        return true;
    }
}
