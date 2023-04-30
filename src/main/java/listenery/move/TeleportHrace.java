package listenery.move;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TeleportHrace implements Listener {


    @EventHandler
    public void projdiPortalem(PlayerTeleportEvent event) {
        World svet = event.getFrom().getWorld();
        Player hrac = event.getPlayer();
        ItemStack perla = new ItemStack(Material.ENDER_PEARL, 10);
        ItemStack jablko = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE, 10);

        if (event.getCause() != PlayerTeleportEvent.TeleportCause.NETHER_PORTAL) return;
        svet.playSound(hrac.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL, 5, (float) 0.7);
        hrac.sendMessage("Utekls do Netheru");
        hrac.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 2000, 2, true, true, false));
        hrac.getInventory().addItem(perla);
        hrac.getInventory().addItem(jablko);
        hrac.setGlowing(true);
    }
}



