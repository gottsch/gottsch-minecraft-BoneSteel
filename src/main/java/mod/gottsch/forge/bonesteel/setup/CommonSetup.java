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
package mod.gottsch.forge.bonesteel.setup;

import mod.gottsch.forge.bonesteel.BoneSteel;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

/**
 * 
 * @author Mark Gottschling on Aug 17, 2022
 *
 */
@Mod.EventBusSubscriber(modid = BoneSteel.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommonSetup {
	// TODO tab group stuff doesn't belong here
	public static final String TAB_NAME = "bonesteel";

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(TAB_NAME) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Registration.RAW_TITANIUM.get()); // TODO change to logo icon
        }
    };
    
    public static void setup() {
        IEventBus bus = MinecraftForge.EVENT_BUS;
    }
    
    public static void init(FMLCommonSetupEvent event) {
//        event.enqueueWork(() -> {
//            Ores.registerConfiguredFeatures();
//            Dimensions.register();
//        });
//        Messages.register();
    }
}
