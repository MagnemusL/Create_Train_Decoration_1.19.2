package net.magne.traindeco.util.sounds;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.player.Player;

public class SoundHelper {
    public static void playSound(Player player, SoundEvent soundEvent, float volume, float pitch) {
        player.level.playSound(null, player.getX(), player.getY(), player.getZ(), soundEvent, SoundSource.PLAYERS, volume, pitch);
    }
}
