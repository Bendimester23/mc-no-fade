package io.github.ultimateboomer.nofade.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.screen.SplashScreen;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SplashScreen.class)
public abstract class SplashScreenMixin extends DrawableHelper {
    @Shadow private long applyCompleteTime;

    @Shadow @Final private MinecraftClient client;

    @Inject(method = "render", at = @At("HEAD"))
    private void onRender(MatrixStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (this.applyCompleteTime > 1) {
            this.client.setOverlay(null);
        }
    }

}
