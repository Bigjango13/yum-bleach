package useless.yumbleach.mixin;

import useless.yumbleach.YumBleach;

import goocraft4evr.nonamedyes.crafting.ModRecipes;
import goocraft4evr.nonamedyes.item.ModItems;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;

import turniplabs.halplibe.helper.RecipeBuilder;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = ModRecipes.class, remap = false)
public class ModCraftingManagerMixin {
    @Inject(method = "craftingRecipes", at = @At("TAIL"))
    private void addRecipe(CallbackInfo ci){
        RecipeBuilder.Shapeless(YumBleach.MOD_ID)
            .addInput(Item.bucketWater)
            .addInput(ModItems.bleachingPowder)
            .create("yummy_bleach", new ItemStack(YumBleach.bleach));
    }
}
