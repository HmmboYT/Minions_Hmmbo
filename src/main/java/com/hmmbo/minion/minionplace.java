package com.hmmbo.minion;

import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

public class minionplace implements Listener {
    private  Maiin main;
    private  Plugin plugin;
    public minionplace(Maiin maiin, Plugin plugin) {
        this.main = maiin;
        this.plugin = plugin;
    }
    @EventHandler
    public void onplace(BlockPlaceEvent s)
    {
        Player player = s.getPlayer();
        if(s.getBlock().getType() == Material.PLAYER_HEAD){
            ArmorStand stand = (ArmorStand) player.getWorld().spawnEntity(s.getBlock().getLocation().add(0.5,0.5,0.5),EntityType.ARMOR_STAND);
            //Methods you can do to the armor stand
            stand.setHelmet(new ItemStack(Material.PLAYER_HEAD));
            stand.setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            stand.setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));
            stand.setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            stand.setSmall(true);
            stand.setBasePlate(false);
            stand.setArms(true);
            stand.setItemInHand(new ItemStack(Material.DIAMOND_PICKAXE));
            stand.setCustomNameVisible(true);
            stand.setCustomName("Minor");
            s.getBlock().setType(Material.AIR);
        }

    }
}
