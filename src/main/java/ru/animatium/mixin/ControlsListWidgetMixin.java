package ru.animatium.mixin;

import net.minecraft.client.gui.screen.option.ControlsListWidget;
import net.minecraft.client.option.KeyBinding;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Locale;

@Mixin(ControlsListWidget.class)
public abstract class ControlsListWidgetMixin {
    @Inject(method = "update", at = @At("TAIL"))
    private void animatium$hideSelectedRows(CallbackInfo ci) {
        // children() is inherited from EntryListWidget. Do not @Shadow it here:
        // Mixin cannot shadow an inherited method as if it were declared on this class.
        ControlsListWidget self = (ControlsListWidget) (Object) this;

        self.children().removeIf(entry -> {
            if (!(entry instanceof ControlsListWidget.KeyBindingEntry)) {
                return false;
            }

            KeyBinding binding =
                    ((KeyBindingEntryAccessor) (Object) entry).animatium$getBinding();

            String id = binding.getId().toLowerCase(Locale.ROOT);

            return id.contains("macecore")
                    || id.contains("mace_core")
                    || id.equals("key.shieldbreaker.open_gui");
        });
    }
}
