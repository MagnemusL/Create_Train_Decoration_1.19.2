package net.magne.traindeco.block.custom;

import net.magne.traindeco.util.sounds.SoundHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class WaterBlock extends Block {

    public WaterBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, RandomSource source) {
        super.tick(state, level, pos, source);

        if (level instanceof ServerLevel) {
            ServerLevel serverWorld = level;
            Player player = serverWorld.getNearestPlayer(pos.getX(), pos.getY(), pos.getZ(), -1.0, false);
            if (player != null) {
                SoundHelper.playSound(level, pos, SoundEvents.GENERIC_EXPLODE, 5.0f, 1.0f);
                }
            }
    }


    public boolean lithiumReaction(BlockPos pos, Player player, Level level) {
        if (areSurroundingBlocksWater(level, pos)) {
            SoundHelper.playSound(player, SoundEvents.GENERIC_EXPLODE, 1.0f, 1.0f);
            return true;
        }
        return false;
    }

    public boolean areSurroundingBlocksWater(Level world, BlockPos pos) {
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        // Check each surrounding block
        if (world.getBlockState(new BlockPos(x - 1, y, z)).getBlock() == Blocks.WATER ||
                world.getBlockState(new BlockPos(x + 1, y, z)).getBlock() == Blocks.WATER ||
                world.getBlockState(new BlockPos(x, y - 1, z)).getBlock() == Blocks.WATER ||
                world.getBlockState(new BlockPos(x, y + 1, z)).getBlock() == Blocks.WATER ||
                world.getBlockState(new BlockPos(x, y, z - 1)).getBlock() == Blocks.WATER ||
                world.getBlockState(new BlockPos(x, y, z + 1)).getBlock() == Blocks.WATER) {
            return true;
        }

        return false; // No surrounding water blocks
    }
}