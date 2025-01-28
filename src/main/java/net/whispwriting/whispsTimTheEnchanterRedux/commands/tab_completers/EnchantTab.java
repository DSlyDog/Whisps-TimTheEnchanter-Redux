package net.whispwriting.whispsTimTheEnchanterRedux.commands.tab_completers;

import org.bukkit.Registry;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.enchantments.Enchantment;

import java.util.ArrayList;
import java.util.List;

public class EnchantTab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String label, String[] args) {
        if (args.length == 1){
            List<String> options = new ArrayList<>();
            options.add("all");

            List<Enchantment> enchantments = Registry.ENCHANTMENT.stream().toList();
            for (Enchantment enchantment : enchantments){
                options.add(enchantment.getKey().getKey());
            }
            return options;
        }
        return null;
    }
}
