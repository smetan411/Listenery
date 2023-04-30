package listenery.veci;

import listenery.PlayerCommandExecutor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Excalibur extends PlayerCommandExecutor {

    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {

        ItemStack mec = new ItemStack(Material.STONE_SWORD, 1);
        ItemMeta itemMeta = mec.getItemMeta();
        itemMeta.setUnbreakable(true);
      // mec.addEnchantment(Enchantment.DAMAGE_ALL, 50);
        itemMeta.setDisplayName("Excalibur");

//        AttributeModifier attackModifier = new AttributeModifier("AdditionalDamage", 10, AttributeModifier.Operation.ADD_NUMBER);
//        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attackModifier);
        mec.setItemMeta(itemMeta);
        player.getInventory().addItem(mec);
        return true;

    }
}
