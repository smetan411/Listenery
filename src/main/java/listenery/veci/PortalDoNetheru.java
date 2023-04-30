package listenery.veci;

import listenery.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PortalDoNetheru extends PlayerCommandExecutor {
    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        ItemStack portal = new ItemStack(Material.OBSIDIAN, 14);
        ItemStack zapalovac = new ItemStack(Material.FLINT_AND_STEEL); //FIRE_CHARGE
        player.getInventory().addItem(portal, zapalovac);
        return true;
    }
}
