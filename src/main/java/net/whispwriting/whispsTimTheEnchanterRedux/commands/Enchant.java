package net.whispwriting.whispsTimTheEnchanterRedux.commands;

import net.whispwriting.whispsTimTheEnchanterRedux.utils.Enchanter;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Enchant implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if (!(commandSender instanceof Player)){
            commandSender.sendMessage("This command is usable only by players");
            return true;
        }

        if (args.length < 1){
            commandSender.sendMessage(ChatColor.RED + "This command requires an argument: <level:all>");
            return true;
        }

        Player player = (Player) commandSender;
        ItemStack item = player.getItemInUse();

        if (args[1].equals("all")) {
            Enchanter enchantment = new Enchanter(item, -1);
            item = enchantment.enchantAll(true);
        }
        return true;
    }
}
