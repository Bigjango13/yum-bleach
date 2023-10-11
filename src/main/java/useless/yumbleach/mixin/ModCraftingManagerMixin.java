package useless.yumbleach.mixin;

import goocraft4evr.nonamedyes.crafting.ModCraftingManager;
import goocraft4evr.nonamedyes.item.ModItems;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import turniplabs.halplibe.helper.RecipeHelper;
import useless.yumbleach.YumBleach;

@Mixin(value = ModCraftingManager.class, remap = false)
public class ModCraftingManagerMixin {
    @Inject(method = "register()V", at = @At("TAIL"))
    private static void addRecipe(CallbackInfo ci){
        RecipeHelper.craftingManager.addShapelessRecipe(new ItemStack(YumBleach.bleach, 1, 0), new Object[]{new ItemStack(Item.bucketWater, 1, 0), new ItemStack(ModItems.bleachingPowder, 1, 0)});
    }
}
