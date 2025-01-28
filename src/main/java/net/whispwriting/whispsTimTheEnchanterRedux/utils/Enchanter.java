package net.whispwriting.whispsTimTheEnchanterRedux.utils;

import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class Enchanter {

    private static Enchanter instance;
    List<String> timQuotes = new ArrayList<String>();
    List<String> articles;

    private Enchanter(){
        timQuotes.add("I... am an enchanter. ");
        timQuotes.add("There are some who call me... 'Tim'? ");
        timQuotes.add("Yes, I can help you find the Holy Grail. ");
        timQuotes.add("To the north there lies a cave-- the cave of Caerbannog-- wherein, carved in mystic runes upon the very living rock, the last words of Olfin Bedwere of Rheged... ");
        timQuotes.add("Follow. But! Follow only if ye be men of valour, for the entrance to this cave is guarded by a creature so foul, so cruel that no man yet has fought with it and lived!");
        timQuotes.add("So, brave knights, if you do doubt your courage or your strength, come no further, for death awaits you all with nasty, big, pointy teeth. ");
        timQuotes.add("Behold the cave of Caerbannog! ");
        timQuotes.add("That's the most foul, cruel, and bad-tempered rodent you ever set eyes on! Look, that rabbit's got a vicious streak a mile wide! It's a killer!");
        timQuotes.add("I warned you, but did you listen to me? Oh, no, you knew it all, didn't you? Oh, it's just a harmless little bunny, isn't it? Well, it's always the same. I always tell them-- ");

        articles = Arrays.asList("a", "an", "the");
    }

    public Result enchant(ItemStack item, int level, String name, boolean unsafe){
        Enchantment enchantment;
        try {
            enchantment = Registry.ENCHANTMENT.getOrThrow(NamespacedKey.minecraft(name));
        }catch(NoSuchElementException e){
            return new Result(null, "That is not an enchantment I can do.");
        }

        if (unsafe)
            item.addUnsafeEnchantment(enchantment, level);
        else
            item.addEnchantment(enchantment, level);

        return new Result(item, getQuote());
    }

    public Result enchantAll(ItemStack item, int level, boolean unsafe){
        for (Enchantment enchantment : Registry.ENCHANTMENT.stream().toList()){
            if (unsafe)
                item.addUnsafeEnchantment(enchantment, level);
            else
                item.addEnchantment(enchantment, level);
        }

        return new Result(item, getQuote());
    }

    private String getQuote(){
        Random random = new Random();
        int index = random.nextInt(timQuotes.size());
        return timQuotes.get(index);
    }

    public static Enchanter getInstance(){
        if (instance == null)
            instance = new Enchanter();

        return instance;
    }

    public class Result {
        private ItemStack item;
        private String quote;

        public Result(ItemStack item, String quote){
            this.item = item;
            this.quote = quote;
        }

        public ItemStack item(){
            return this.item;
        }

        public String quote(){
            return this.quote;
        }
    }
}
