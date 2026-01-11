package net.tropicbliss.options;

import net.minecraft.client.option.SimpleOption;

import static net.minecraft.client.option.GameOptions.getPercentValueText;

public class OptionsManager {
    public static SimpleOption<Double> sensitivityScalingOption = new SimpleOption<>("options.mouse.sensitivity.multiplier", SimpleOption.emptyTooltip(), (optionText, value) -> getPercentValueText(optionText, (double)2.0F * value), SimpleOption.DoubleSliderCallbacks.INSTANCE, (double)0.5F, (value) -> {});
}
