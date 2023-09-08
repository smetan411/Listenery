package listenery;

import listenery.damage.*;
import listenery.death.SmrtSpawn;
import listenery.death.SmrtPojmenovaneEntity;
import listenery.death.Drops;
import listenery.move.ChuzeDiamant;
import listenery.move.TeleportHrace;
import listenery.target.BleskHelmaListener;
import listenery.veci.*;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class MainListenery extends JavaPlugin {

    @Override
    public void onEnable() {
        World world = getServer().getWorlds().get(0);
        getPlugin(MainListenery.class).getLogger().info("plugin enabled");
        // komandy
        getCommand("-endMec").setExecutor(new EndMec());
        getCommand("-excalibur").setExecutor(new Excalibur());
        getCommand("-kladivo").setExecutor(new Kladivo());
        getCommand("-magickaHulka").setExecutor(new MagickaHulka());
        getCommand("-duhovaOvecka").setExecutor(new DuhovaOvecka());
        getCommand("-diaBoty").setExecutor(new DiamantoveBoty());
        getCommand("-bleskovaHelma").setExecutor(new BleskovaHelma());
        getCommand("-liskaBystrouska").setExecutor(new LiskaBystrouska());
        getCommand("-sekera").setExecutor(new Sekera());
        getCommand("-motyka").setExecutor(new Sekera());
        getCommand("-netherPortal").setExecutor(new PortalDoNetheru());
        getCommand("-ohnivaHulka").setExecutor(new OhnivaHulka());



        // listenery
        getServer().getPluginManager().registerEvents(new EndMecListener(), this);
        getServer().getPluginManager().registerEvents(new ExcaliburListener(), this);
        getServer().getPluginManager().registerEvents(new MotykaListener(), this);
        getServer().getPluginManager().registerEvents(new MagickaHulkaListener(), this);
        getServer().getPluginManager().registerEvents(new SmrtSpawn(), this);
        getServer().getPluginManager().registerEvents(new Drops(), this);
        getServer().getPluginManager().registerEvents(new ChuzeDiamant(), this);
        getServer().getPluginManager().registerEvents(new BleskHelmaListener(), this);
        getServer().getPluginManager().registerEvents(new SmrtPojmenovaneEntity(), this);
        getServer().getPluginManager().registerEvents(new SekeraListener(), this);
        getServer().getPluginManager().registerEvents(new KladivoListener(), this);
        getServer().getPluginManager().registerEvents(new TeleportHrace(), this);
        getServer().getPluginManager().registerEvents(new OhnivaHulkaListener(), this);
    }


}
