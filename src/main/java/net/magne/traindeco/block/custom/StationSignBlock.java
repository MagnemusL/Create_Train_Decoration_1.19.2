package net.magne.traindeco.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class StationSignBlock extends HorizontalDirectionalBlock {
    public static DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;
    public StationSignBlock(Properties properties)
    {
        super(properties);
    }

    private static final VoxelShape SHAPE = Block.box(-3, 0, 4, 19, 16, 12);

    @Override
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        Direction facing = blockState.getValue(FACING);
        // Adjust the VoxelShape based on the facing direction
        if (facing == Direction.NORTH) {
            return Block.box(-3, 0, 3, 19, 16, 12);  // Same shape for north direction
        } else if (facing == Direction.EAST) {
            return Block.box(4, 0, -3, 13, 16, 19);   // Same shape for east direction
        } else if (facing == Direction.SOUTH) {
            return Block.box(-3, 0, 4, 19, 16, 13);  // Same shape for south direction
        } else if (facing == Direction.WEST) {
            return Block.box(3, 0, -3, 12, 16, 19);   // Same shape for west direction
        }
        return SHAPE;
    }


    @Override
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        return this.defaultBlockState().setValue(FACING, pContext.getHorizontalDirection().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(FACING, pRotation.rotate(pState.getValue(FACING)));
    }

    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(FACING)));
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }
}
