package listenery.veci;

import listenery.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Kladivo extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        ItemStack kladivo = new ItemStack(Material.IRON_AXE, 1);  //lopata
        ItemMeta itemMeta = kladivo.getItemMeta();
        itemMeta.setDisplayName("Kladivo");
        itemMeta.setUnbreakable(true);
        kladivo.setItemMeta(itemMeta);
        player.getInventory().addItem(kladivo);
        return true;
    }
}
