package net.whispwriting.whispsTimTheEnchanterRedux;

import net.whispwriting.whispsTimTheEnchanterRedux.commands.Enchant;
import org.bukkit.plugin.java.JavaPlugin;

public final class WhispsTimTheEnchanterRedux extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("enchant").setExecutor(new Enchant());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
