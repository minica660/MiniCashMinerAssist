package MiniCash;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class Model {
    private MiniCashShigenAssist plugin;
    public Model(MiniCashShigenAssist plugin) {
        this.plugin = plugin;
    }
    private Map<UUID,Integer> elytra = new HashMap<>();

    public Map<UUID,Integer> getElytra() {
        return elytra;
    }
    public void setElytra(UUID id, Integer amount) {

        elytra.put(id,amount);

    }

    public void removeElytra(UUID id) {
        elytra.remove(id);
    }


    private List<UUID> checkNightVision = new ArrayList<>();
    private List<UUID> checkDurability = new ArrayList<>();

    public List<UUID> getCheckNightVision() {
        return checkNightVision;
    }

    public void setCheckNightVision(UUID id) {
        checkNightVision.add(id);
    }

    public void removeCheckNightVision(UUID id) {
        checkNightVision.remove(id);
    }

    public List<UUID> getCheckDurability() {
        return checkDurability;
    }

    public void setCheckDurability(UUID id) {
        checkDurability.add(id);
    }

    public void removeCheckDurability(UUID id) {
        checkDurability.remove(id);
    }


    public void nightVision() {
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {

            getCheckNightVision().forEach((uuid)->{

                Player player = Bukkit.getPlayer(uuid);

                if(player != null && player.isOnline()) {

                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 800, 1, false, false));

                }
            });

            }, 0L, 600L);

    }


}
