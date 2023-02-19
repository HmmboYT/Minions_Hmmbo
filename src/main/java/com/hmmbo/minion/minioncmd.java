package com.hmmbo.minion;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class minioncmd implements CommandExecutor {
    Plugin plugin;
    Maiin maiin;
    public minioncmd(Plugin pluign,Maiin maiin){
        this.plugin = pluign;
        this.maiin= maiin;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(args[0] == "stone");
            {
                ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
                //Methods you can do to the armor stand
                stand.setHelmet(new ItemStack(Material.PLAYER_HEAD));
                stand.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                stand.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                stand.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                stand.setSmall(true);
                stand.setBasePlate(false);
                stand.setArms(true);
                stand.setItemInHand(new ItemStack(Material.DIAMOND_PICKAXE));
                stand.setCustomName("Stone minion");


            }
            if(args[0] == "stone");
            {
                ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(player.getLocation(), EntityType.ARMOR_STAND);
                //Methods you can do to the armor stand
                stand.setHelmet(new ItemStack(Material.PLAYER_HEAD));
                stand.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
                stand.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
                stand.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
                stand.setSmall(true);
                stand.setBasePlate(false);
                stand.setArms(true);
                stand.setItemInHand(new ItemStack(Material.DIAMOND_PICKAXE));
                stand.setCustomName("Coal minion");


            }
        }


        return false;


    }
}
