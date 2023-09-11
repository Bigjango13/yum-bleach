package useless.yumbleach.mixin;

import goocraft4evr.nonamedyes.block.entity.TileEntityBleacher;
import goocraft4evr.nonamedyes.item.ModItems;
import net.minecraft.core.item.ItemStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import useless.yumbleach.YumBleach;

@Mixin(value = TileEntityBleacher.class, remap = false)
public class bleacherMixin {
    @Final
    @Shadow
    private ItemStack[] bleacherItemStacks;

    @Inject(method = "getFuelTime()I", at = @At("HEAD"), cancellable = true)
    private void canBleachExtras(CallbackInfoReturnable<Integer> cir){
        ItemStack itemStack = this.bleacherItemStacks[0];
        if (itemStack == null) {
            cir.setReturnValue(0);
        } else if (itemStack.itemID == YumBleach.bleach.id){
            cir.setReturnValue(1600);
        }
    }
}
