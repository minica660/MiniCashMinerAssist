package MiniCash.commands;

import MiniCash.GUIHolder;
import MiniCash.MiniCashShigenAssist;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
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

public class AssistCommand implements CommandExecutor {

    private MiniCashShigenAssist plugin;

    public AssistCommand(MiniCashShigenAssist plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player player){

            Inventory inventory = Bukkit.createInventory(new GUIHolder(),9, Component.text("資源アシスト" , NamedTextColor.DARK_GREEN).decorate(TextDecoration.BOLD));

            ItemStack nightItem = new ItemStack(Material.EMERALD_BLOCK);
            ItemStack durabilityItem = new ItemStack(Material.EMERALD_BLOCK);
            ItemStack elytraItem = new ItemStack(Material.EMERALD_BLOCK);

            ItemMeta  nightItemMeta = nightItem.getItemMeta();
            ItemMeta durabilityItemMeta = durabilityItem.getItemMeta();
            ItemMeta elytraItemMeta = elytraItem.getItemMeta();

            nightItemMeta.displayName(Component.text("暗視ON状態" , NamedTextColor.GREEN));
            durabilityItemMeta.displayName(Component.text("耐久値警告ON状態", NamedTextColor.GREEN));
            elytraItemMeta.displayName(Component.text("エリトラ補助ON状態" , NamedTextColor.GREEN));

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
                    nightItemMeta.displayName(Component.text("暗視OFF状態" , NamedTextColor.DARK_RED));
                }

            }else {
                nightItem = new  ItemStack(Material.REDSTONE_BLOCK);
                nightItemMeta.displayName(Component.text("暗視OFF状態" , NamedTextColor.DARK_RED));
            }
            if (cDurabilityValue) {

                if (!DurabilityValue){
                    durabilityItem = new  ItemStack(Material.REDSTONE_BLOCK);
                    durabilityItemMeta.displayName(Component.text("耐久値警告OFF状態" , NamedTextColor.DARK_RED));
                }

            }else {
                durabilityItem = new  ItemStack(Material.REDSTONE_BLOCK);
                durabilityItemMeta.displayName(Component.text("耐久値警告OFF状態" , NamedTextColor.DARK_RED));

            }
            if (celytra) {

                if (!elytra){
                    elytraItem = new  ItemStack(Material.REDSTONE_BLOCK);
                    elytraItemMeta.displayName(Component.text("エリトラ補助OFF状態", NamedTextColor.DARK_RED));
                }

            }else {
                elytraItem = new  ItemStack(Material.REDSTONE_BLOCK);
                elytraItemMeta.displayName(Component.text("エリトラ補助OFF状態", NamedTextColor.DARK_RED));
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
