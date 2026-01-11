package net.tropicbliss.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.Mouse;
import net.minecraft.client.option.SimpleOption;
import net.tropicbliss.options.OptionsManager;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Mouse.class)
public class MouseMixin {
    @Shadow
    @Final
    private MinecraftClient client;

    @Redirect(method = "updateMouse", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/SimpleOption;getValue()Ljava/lang/Object;"))
    private Object multiplySensitivity(SimpleOption<?> instance) {
        Object value = instance.getValue();
        if (value instanceof Double && instance == this.client.options.getMouseSensitivity()) {
            return ((Double) value) * OptionsManager.sensitivityScalingOption.getValue() * 2;
        }
        return value;
    }
}
