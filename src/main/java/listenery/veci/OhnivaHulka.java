package listenery.veci;

import listenery.PlayerCommandExecutor;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class OhnivaHulka extends PlayerCommandExecutor {
// minecraft lore je seznam řádků s textem, každý index je jeden řádek
    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        ItemStack ohnivaHulka = new ItemStack(Material.STICK, 1);  //tyčka
        ItemMeta itemMeta = ohnivaHulka.getItemMeta();
        itemMeta.setDisplayName(ChatColor.GOLD + "OhnivaHulka");
        ArrayList<String> seznamVlastnosti = new ArrayList<String>();
        seznamVlastnosti.add(ChatColor.DARK_PURPLE + "RIGHT-CLICK" + ChatColor.GREEN + " to shoot fire ball");
        itemMeta.setLore(seznamVlastnosti);
        ohnivaHulka.setItemMeta(itemMeta);
        player.getInventory().addItem(ohnivaHulka);
        return true;

    }
}
