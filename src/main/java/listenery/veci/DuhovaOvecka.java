package listenery.veci;

import listenery.PlayerCommandExecutor;
import org.bukkit.DyeColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;

import java.util.Timer;
import java.util.TimerTask;

public class DuhovaOvecka extends PlayerCommandExecutor {

    // pouziti tridy Timer a pole barev
    @Override
    public boolean onCommandPlayer(Player player, World world, Location playerLocation, String[] args) {

        Sheep ovce = world.spawn(playerLocation, Sheep.class);
        ovce.setCustomName("DuhovaOvecka");
        ovce.setCustomNameVisible(true);

        Timer casovac = new Timer();
        ObarveniOvce barvi = new ObarveniOvce(ovce);
        casovac.schedule(barvi, 0, 1000);

        return true;
    }

    private static class ObarveniOvce extends TimerTask {
        private Sheep ovce;
        private static DyeColor[] BARVY = {DyeColor.BLUE, DyeColor.GREEN, DyeColor.YELLOW, DyeColor.ORANGE, DyeColor.PINK,
                DyeColor.PURPLE, DyeColor.RED, DyeColor.LIGHT_BLUE, DyeColor.LIME, DyeColor.WHITE};
        private int indexBarvy = 0;

        public ObarveniOvce(Sheep ovce) {
            this.ovce = ovce;
        }

        @Override
        public void run() {
            if (ovce.isDead()) cancel();
            ovce.setColor(BARVY[indexBarvy]);
            indexBarvy++;
            if (indexBarvy == BARVY.length) indexBarvy = 0;
        }
    }
}
