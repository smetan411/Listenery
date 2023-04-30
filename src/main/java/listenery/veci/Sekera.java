package listenery.veci;

import listenery.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Sekera extends PlayerCommandExecutor {
    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        ItemStack sekera = new ItemStack(Material.IRON_AXE, 1);
        ItemMeta itemMeta = sekera.getItemMeta();
        itemMeta.setDisplayName("Sekera");
        itemMeta.setUnbreakable(true);
        sekera.setItemMeta(itemMeta);
        player.getInventory().addItem(sekera);
        return true;
    }
}
