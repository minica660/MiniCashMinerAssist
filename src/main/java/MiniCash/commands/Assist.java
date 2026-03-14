package MiniCash.commands;

import MiniCash.Event;
import MiniCash.GUI;
import MiniCash.MiniCashShigenAssist;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.io.File;

public class Assist implements CommandExecutor {

    private Event e;
    private MiniCashShigenAssist plugin;
    public Assist(Event e, MiniCashShigenAssist plugin) {
        this.e = e;
        this.plugin = plugin;
    }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player){

            Player player = (Player) commandSender;

            Inventory inventory = Bukkit.createInventory(new GUI(),9,"§2資源アシスト");

            ItemStack nightItem = new ItemStack(Material.EMERALD_BLOCK);
            ItemStack durabilityItem = new ItemStack(Material.EMERALD_BLOCK);
            ItemStack elytraItem = new ItemStack(Material.EMERALD_BLOCK);

            ItemMeta  nightItemMeta = nightItem.getItemMeta();
            ItemMeta durabilityItemMeta = durabilityItem.getItemMeta();
            ItemMeta elytraItemMeta = elytraItem.getItemMeta();

            nightItemMeta.setDisplayName("§a暗視ON状態");
            durabilityItemMeta.setDisplayName("§a耐久値警告ON状態");
            elytraItemMeta.setDisplayName("§aエリトラ補助ON状態");

            File playerFile = new File((plugin.getDataFolder()), "players/" + player.getUniqueId() + ".yml");

            FileConfiguration playerConfig = YamlConfiguration.loadConfiguration(playerFile);

            boolean cnightVison = plugin.getConfig().getBoolean("night_vision");
            boolean cDurabilityValue = plugin.getConfig().getBoolean("Durability_value");
            boolean celytra = plugin.getConfig().getBoolean("elytra");

            boolean nightVision = playerConfig.getBoolean("night_vision");
            boolean DurabilityValue = playerConfig.getBoolean("Durability_value");
            boolean elytra = playerConfig.getBoolean("elytra");

            if (cnightVison) {

                if (!nightVision){
                    nightItem = new  ItemStack(Material.REDSTONE_BLOCK);
                    nightItemMeta.setDisplayName("§4暗視OFF状態");
                }

            }else {
                nightItem = new  ItemStack(Material.REDSTONE_BLOCK);
                nightItemMeta.setDisplayName("§4暗視OFF状態");
            }
            if (cDurabilityValue) {

                if (!DurabilityValue){
                    durabilityItem = new  ItemStack(Material.REDSTONE_BLOCK);
                    durabilityItemMeta.setDisplayName("§4耐久値警告OFF状態");
                }

            }else {
                durabilityItem = new  ItemStack(Material.REDSTONE_BLOCK);
                durabilityItemMeta.setDisplayName("§4耐久値警告OFF状態");

            }
            if (celytra) {

                if (!elytra){
                    elytraItem = new  ItemStack(Material.REDSTONE_BLOCK);
                    elytraItemMeta.setDisplayName("§4エリトラ補助OFF状態");
                }

            }else {
                elytraItem = new  ItemStack(Material.REDSTONE_BLOCK);
                elytraItemMeta.setDisplayName("§4エリトラ補助OFF状態");
            }

            nightItem.setItemMeta(nightItemMeta);
            durabilityItem.setItemMeta(durabilityItemMeta);
            elytraItem.setItemMeta(elytraItemMeta);


            inventory.setItem(1, nightItem);
            inventory.setItem(3, durabilityItem);
            inventory.setItem(5,elytraItem);

            player.openInventory(inventory);

        }



        return true;
    }
}



        return true;
    }
}
