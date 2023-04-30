package listenery.veci;

import listenery.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EndMec extends PlayerCommandExecutor {
    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {
        ItemStack endMec = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta itemMeta = endMec.getItemMeta();
        itemMeta.setDisplayName("EndMec");
        itemMeta.setUnbreakable(true);
        AttributeModifier attackModifier = new AttributeModifier("Damage", 10, AttributeModifier.Operation.ADD_NUMBER);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attackModifier);
        endMec.setItemMeta(itemMeta);
        player.getInventory().addItem(endMec);
        return true;
    }



}
