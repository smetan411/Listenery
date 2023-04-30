package listenery.veci;

import listenery.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Motyka extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        ItemStack motyka = new ItemStack(Material.IRON_HOE, 1);  //lopata
        ItemMeta itemMeta = motyka.getItemMeta();
        itemMeta.setDisplayName("Motyka");
        itemMeta.setUnbreakable(true);
        motyka.setItemMeta(itemMeta);
        player.getInventory().addItem(motyka);
        return true;
    }
}
