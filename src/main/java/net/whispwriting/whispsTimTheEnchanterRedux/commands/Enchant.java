package net.whispwriting.whispsTimTheEnchanterRedux.commands;

import net.whispwriting.whispsTimTheEnchanterRedux.utils.Enchanter;
import org.bukkit.ChatColor;
import org.bukkit.Material;
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

        if (args.length < 2){
            commandSender.sendMessage(ChatColor.RED + "This command requires two arguments: <level:all>");
            return true;
        }

        Player player = (Player) commandSender;
        ItemStack item = player.getInventory().getItemInMainHand();
        int level;

        if (item.getType() == Material.AIR){
            player.sendMessage(ChatColor.YELLOW + "[Tim] I cannot enchant NOTHING you FOOL!");
            return true;
        }

        try{
            level = Integer.parseInt(args[1]);
        }catch (NumberFormatException e){
            player.sendMessage(ChatColor.YELLOW + "[Tim] You power level must be a number.");
            return true;
        }

        if (args[0].equals("all")) {
            Enchanter.Result result = Enchanter.getInstance().enchantAll(item, level, true);
            player.getInventory().setItemInMainHand(result.item());
            player.sendMessage(ChatColor.YELLOW + "[Tim] " + result.quote());
            return true;
        }

        Enchanter.Result result = Enchanter.getInstance().enchant(item, level, args[0], true);
        player.getInventory().setItemInMainHand(result.item() == null ? item : result.item());
        player.sendMessage(ChatColor.YELLOW + "[Tim] " + result.quote());
        return true;
    }
}
