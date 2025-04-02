package net.genesis.tutorialmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent CAULIFLOWER = new FoodComponent.Builder().nutrition(3).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 0.15f).build();

    public static final FoodComponent COOKED_DRUMSTICK = new FoodComponent.Builder().nutrition(4).saturationModifier(0.50f).build();

    public static final FoodComponent RAW_DRUMSTICK = new FoodComponent.Builder().nutrition(1).saturationModifier(0.15f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 550), 0.15f).build();
}
