package com.lynxxdg.lynxMinecarts;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Minecart;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleExitEvent;

public class EventHandler implements Listener {
    private final double defaultSpeed;
    private final double fastSpeed;

    public EventHandler(double defaultSpeed, double fastSpeed) {
        this.defaultSpeed = defaultSpeed;
        this.fastSpeed = fastSpeed;
    }

    public static double ConvertSpeed(double blocksPerSecond) {
        // convert speed from blocks per second to blocks per tick
        return blocksPerSecond / 20.0;
    }
    @org.bukkit.event.EventHandler(ignoreCancelled = true)
    private void onVehicleEnter(VehicleEnterEvent event) {
        // check if a player just entered a minecart
        if (event.getVehicle().getType() != EntityType.MINECART)
            return;
        if (event.getEntered().getType() != EntityType.PLAYER)
            return;
        Minecart minecart = (Minecart) event.getVehicle();
        minecart.setMaxSpeed(ConvertSpeed(this.fastSpeed));
    }

    @org.bukkit.event.EventHandler(ignoreCancelled = true)
    private void onVehicleExit(VehicleExitEvent event) {
        // check if the vehicle being left is a minecart (no need to check if left by player)
        if (event.getVehicle().getType() != EntityType.MINECART)
            return;
        Minecart minecart = (Minecart) event.getVehicle();
        minecart.setMaxSpeed(ConvertSpeed(this.defaultSpeed));
    }
}
