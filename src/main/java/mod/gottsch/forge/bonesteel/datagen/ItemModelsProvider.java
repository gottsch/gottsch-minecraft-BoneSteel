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

import mod.gottsch.forge.bonesteel.BoneSteel;
import mod.gottsch.forge.bonesteel.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

/**
 * 
 * @author Mark Gottschling on Aug 17, 2022
 *
 */
public class ItemModelsProvider extends ItemModelProvider {

    public ItemModelsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, BoneSteel.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    	
    	withExistingParent(Registration.TITANIUM_ORE_ITEM.get().getRegistryName().getPath(), modLoc("block/titanium_ore"));
    	withExistingParent(Registration.DEEPSLATE_TITANIUM_ORE_ITEM.get().getRegistryName().getPath(), modLoc("block/deepslate_titanium_ore"));
    	withExistingParent(Registration.TITANIUM_BLOCK_ITEM.get().getRegistryName().getPath(), modLoc("block/titanium_block"));
    	
    	// raw ores
        singleTexture(Registration.RAW_TITANIUM.get().getRegistryName().getPath(),
        		mcLoc("item/generated"), "layer0", modLoc("item/raw_titanium"));
        
        // ingots
        singleTexture(Registration.TITANIUM_INGOT.get().getRegistryName().getPath(),
        		mcLoc("item/generated"), "layer0", modLoc("item/titanium_ingot"));
        
        // weapons
        singleTexture(Registration.BONE_SWORD.get().getRegistryName().getPath(),
        		mcLoc("item/handheld"), "layer0", modLoc("item/bone_sword"));
        
        singleTexture(Registration.STEEL_SWORD.get().getRegistryName().getPath(),
        		mcLoc("item/handheld"), "layer0", modLoc("item/steel_sword"));
        
        singleTexture(Registration.BONE_STEEL_SWORD.get().getRegistryName().getPath(),
        		mcLoc("item/handheld"), "layer0", modLoc("item/bone_steel_sword"));
        
        singleTexture(Registration.TITANIUM_SWORD.get().getRegistryName().getPath(),
        		mcLoc("item/handheld"), "layer0", modLoc("item/titanium_sword"));
        
        singleTexture(Registration.AUTIUM_SWORD.get().getRegistryName().getPath(),
        		mcLoc("item/handheld"), "layer0", modLoc("item/autium_sword"));

        // tools
        singleTexture(Registration.TITANIUM_AXE.get().getRegistryName().getPath(),
        		mcLoc("item/handheld"), "layer0", modLoc("item/titanium_axe"));
        singleTexture(Registration.TITANIUM_HOE.get().getRegistryName().getPath(),
        		mcLoc("item/handheld"), "layer0", modLoc("item/titanium_hoe"));
        singleTexture(Registration.TITANIUM_PICKAXE.get().getRegistryName().getPath(),
        		mcLoc("item/handheld"), "layer0", modLoc("item/titanium_pickaxe"));
        singleTexture(Registration.TITANIUM_SHOVEL.get().getRegistryName().getPath(),
        		mcLoc("item/handheld"), "layer0", modLoc("item/titanium_shovel"));
        
        // armor
        singleTexture(Registration.TITANIUM_HELMET.get().getRegistryName().getPath(),
        		mcLoc("item/generated"), "layer0", modLoc("item/titanium_helmet"));
        singleTexture(Registration.TITANIUM_CHESTPLATE.get().getRegistryName().getPath(),
        		mcLoc("item/generated"), "layer0", modLoc("item/titanium_chestplate"));
        singleTexture(Registration.TITANIUM_LEGGINGS.get().getRegistryName().getPath(),
        		mcLoc("item/generated"), "layer0", modLoc("item/titanium_leggings"));
        singleTexture(Registration.TITANIUM_BOOTS.get().getRegistryName().getPath(),
        		mcLoc("item/generated"), "layer0", modLoc("item/titanium_boots"));
    }
}
