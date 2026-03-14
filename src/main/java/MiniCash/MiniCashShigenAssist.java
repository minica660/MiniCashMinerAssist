package MiniCash;

import MiniCash.commands.Assist;
import org.bukkit.plugin.java.JavaPlugin;

public final class MiniCashShigenAssist extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        MPublic mPublic = new MPublic(this);
        Event e = new Event(this,mPublic);
        getCommand("assist").setExecutor(new Assist(e,this));
        getCommand("minerassist").setExecutor(new Assist(e,this));
        getServer().getPluginManager().registerEvents(e, this);

        saveDefaultConfig();

        mPublic.nightVision();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
