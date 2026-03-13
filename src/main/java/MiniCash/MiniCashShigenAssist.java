package MiniCash;

import MiniCash.commands.Assist;
import org.bukkit.plugin.java.JavaPlugin;

public final class MiniCashShigenAssist extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Event e = new Event(this);
        getCommand("assist").setExecutor(new Assist(e,this));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
