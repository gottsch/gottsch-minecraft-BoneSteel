package mod.gottsch.forge.bonesteel.client.renderer.armor;

import mod.gottsch.forge.bonesteel.client.model.armor.TitaniumArmorModel;
import mod.gottsch.forge.bonesteel.item.TitaniumArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class TitaniumArmorRenderer extends GeoArmorRenderer<TitaniumArmorItem>{

	public TitaniumArmorRenderer() {
		super(new TitaniumArmorModel());
		
		this.headBone = "armorHead";
		this.bodyBone = "armorBody";
		this.rightArmBone = "armorRightArm";
		this.leftArmBone = "armorLeftArm";
		// note the switch leg assignments
		this.rightLegBone = "armorLeftLeg";
		this.leftLegBone = "armorRightLeg";
		this.rightBootBone = "armorRightBoot";
		this.leftBootBone = "armorLeftBoot";
	}

}
