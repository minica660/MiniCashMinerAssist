package MiniCash;

import MiniCash.commands.AssistCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class MiniCashShigenAssist extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        Model model = new Model(this);
        Event e = new Event(this, model);
        getCommand("assist").setExecutor(new AssistCommand(this));
        getCommand("minerassist").setExecutor(new AssistCommand(this));
        getServer().getPluginManager().registerEvents(e, this);

        saveDefaultConfig();

        model.nightVision();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
