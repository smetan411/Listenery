package listenery.veci;

import listenery.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MagickaHulka extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        ItemStack magickaHulka = new ItemStack(Material.BLAZE_ROD, 1); // Material.STICK
        ItemMeta itemMeta = magickaHulka.getItemMeta();
        itemMeta.setDisplayName("MagickaHulka");
        itemMeta.setUnbreakable(true);
        magickaHulka.setItemMeta(itemMeta);
        player.getInventory().addItem(magickaHulka);
        return true;
    }

}
