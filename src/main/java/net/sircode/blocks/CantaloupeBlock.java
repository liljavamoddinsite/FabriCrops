package net.sircode.blocks;

import net.minecraft.block.AttachedStemBlock;
import net.minecraft.block.GourdBlock;
import net.minecraft.block.StemBlock;
import net.sircode.FabriCropsMain;

public class CantaloupeBlock extends GourdBlock {
    public CantaloupeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public StemBlock getStem() {
        return (StemBlock) FabriCropsMain.CANTALOUPE_STEM;
    }

    @Override
    public AttachedStemBlock getAttachedStem() {
        return (AttachedStemBlock) FabriCropsMain.ATTACHED_CANTALOUPE_STEM;
    }
}
