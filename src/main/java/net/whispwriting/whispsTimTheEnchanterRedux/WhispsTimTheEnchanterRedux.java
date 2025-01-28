package net.whispwriting.whispsTimTheEnchanterRedux;

import net.whispwriting.whispsTimTheEnchanterRedux.commands.Enchant;
import net.whispwriting.whispsTimTheEnchanterRedux.commands.tab_completers.EnchantTab;
import org.bukkit.plugin.java.JavaPlugin;

public final class WhispsTimTheEnchanterRedux extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("enchant").setExecutor(new Enchant());

        this.getCommand("enchant").setTabCompleter(new EnchantTab());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
