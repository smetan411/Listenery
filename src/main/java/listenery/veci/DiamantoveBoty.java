package listenery.veci;

import listenery.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DiamantoveBoty extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        ItemStack diaBoty = new ItemStack(Material.DIAMOND_BOOTS,1);
        ItemMeta vlastnosti = diaBoty.getItemMeta();
        vlastnosti.setDisplayName("DiaBoty");
        vlastnosti.setUnbreakable(true);
        diaBoty.setItemMeta(vlastnosti);
        //player.getInventory().addItem(diaBoty);
        player.getInventory().setBoots(diaBoty);
        return true;
    }
}
