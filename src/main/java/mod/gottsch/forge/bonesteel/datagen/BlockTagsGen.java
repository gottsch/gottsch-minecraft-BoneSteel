/*
 * This file is part of  Bone Steel.
 * Copyright (c) 2022 Mark Gottschling (gottsch)
 *
 * Bone Steel is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bone Steel is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Bone Steel.  If not, see <http://www.gnu.org/licenses/lgpl>.
 */
package mod.gottsch.forge.bonesteel.datagen;

import org.jetbrains.annotations.Nullable;

import mod.gottsch.forge.bonesteel.BoneSteel;
import mod.gottsch.forge.bonesteel.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

/**
 * 
 * @author Mark Gottschling on Aug 17, 2022
 *
 */
public class BlockTagsGen extends BlockTagsProvider {

	public BlockTagsGen(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
		super(generator, BoneSteel.MODID, existingFileHelper);
	}

    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
        .add(Registration.TITANIUM_ORE.get());
        
        tag(BlockTags.NEEDS_IRON_TOOL)
        .add(Registration.TITANIUM_ORE.get());
        
        tag(Tags.Blocks.ORES)
        .add(Registration.TITANIUM_ORE.get()); 

    }
}
