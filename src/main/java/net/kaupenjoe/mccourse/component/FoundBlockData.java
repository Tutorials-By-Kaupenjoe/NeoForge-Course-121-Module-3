package net.kaupenjoe.mccourse.component;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Objects;

public record FoundBlockData(BlockState block, BlockPos position) {
    public static final Codec<FoundBlockData> CODEC = RecordCodecBuilder.create(instance ->
            instance.group(BlockState.CODEC.fieldOf("block").forGetter(FoundBlockData::block),
                    BlockPos.CODEC.fieldOf("position").forGetter(FoundBlockData::position)).apply(instance, FoundBlockData::new));

    public String getOutputString() {
        return block.getBlock().getName().getString() + " at " + "(" + position.getX() + ", " + position.getY() + ", " + position.getZ() + ")";
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.block, this.position);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        } else {
            return obj instanceof FoundBlockData fbd && this.block == fbd.block && this.position == fbd.position;
        }
    }
}
