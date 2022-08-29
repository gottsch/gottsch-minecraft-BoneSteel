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
import mod.gottsch.forge.bonesteel.setup.CommonSetup;
import mod.gottsch.forge.bonesteel.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

/**
 * 
 * @author Mark Gottschling on Apr 6, 2022
 *
 */
public class LanguageGen extends LanguageProvider {

    public LanguageGen(DataGenerator gen, String locale) {
        super(gen, BoneSteel.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + CommonSetup.TAB_NAME, "Bone Steel");
        
        add(Registration.TITANIUM_ORE.get(), "Titanium Ore");
        add(Registration.DEEPSLATE_TITANIUM_ORE.get(), "Deepslate Titanium Ore");
        add(Registration.TITANIUM_BLOCK.get(), "Titanium Block");
        add(Registration.RAW_TITANIUM.get(), "Raw Titanium");
        
        add(Registration.STEEL_INGOT.get(), "Steel Ingot");
        add(Registration.BONE_STEEL_INGOT.get(), "Bone Steel Ingot");
        add(Registration.TITANIUM_INGOT.get(), "Titanium Ingot");
        add(Registration.AUTIUM_INGOT.get(), "Autium Ingot");
        
        add(Registration.BONE_SWORD.get(), "Bone Sword");
        add(Registration.STEEL_SWORD.get(), "Steel Sword");
        add(Registration.BONE_STEEL_SWORD.get(), "Bone Steel Sword");
        add(Registration.TITANIUM_SWORD.get(), "Titanium Sword");
        add(Registration.AUTIUM_SWORD.get(), "Autium Sword");

        add(Registration.TITANIUM_AXE.get(), "Titanium Axe");
        add(Registration.TITANIUM_HOE.get(), "Titanium Hoe");
        add(Registration.TITANIUM_PICKAXE.get(), "Titanium Pickaxe");
        add(Registration.TITANIUM_SHOVEL.get(), "Titanium Shovel");
        
        add(Registration.BONE_HELMET.get(), "Bone Helmet");
        add(Registration.BONE_CHESTPLATE.get(), "Bone Chestplate");
        add(Registration.BONE_LEGGINGS.get(), "Bone Leggings");
        add(Registration.BONE_BOOTS.get(), "Bone Boots");
        
        add(Registration.TITANIUM_HELMET.get(), "Titanium Helmet");
        add(Registration.TITANIUM_CHESTPLATE.get(), "Titanium Chestplate");
        add(Registration.TITANIUM_LEGGINGS.get(), "Titanium Leggings");
        add(Registration.TITANIUM_BOOTS.get(), "Titanium Boots");
    }
}
