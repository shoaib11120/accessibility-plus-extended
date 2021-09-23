package net.shoaibkhan.accessibiltyplusextended.gui;

import io.github.cottonmc.cotton.gui.client.BackgroundPainter;
import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WButton;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WLabel;
import io.github.cottonmc.cotton.gui.widget.data.HorizontalAlignment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.TranslatableText;
import net.shoaibkhan.accessibiltyplusextended.NarratorPlus;
import net.shoaibkhan.accessibiltyplusextended.config.ConfigKeys;
import net.shoaibkhan.accessibiltyplusextended.modInit;

public class ConfigGui extends LightweightGuiDescription {
  private ClientPlayerEntity player;
  private MinecraftClient client;

  public ConfigGui(ClientPlayerEntity player, MinecraftClient client) {
    this.player = player;
    this.client = client;
    WGridPanel root = new WGridPanel();

    setRootPanel(root);

    ConfigButton nbsStatus = new ConfigButton("gui.apextended.config.buttons.narrateblocksides", ConfigKeys.NARRATE_BLOCK_SIDE_KEY.getKey());
    root.add(nbsStatus, 1, 3, 10, 1);

    ConfigButton enStatus = new ConfigButton("gui.apextended.config.buttons.readentity", ConfigKeys.ENTITY_NARRATOR_KEY.getKey());
    root.add(enStatus, 12, 3, 10, 1);

    ConfigButton fdStatus = new ConfigButton("gui.apextended.config.buttons.falldetector", ConfigKeys.FALL_DETECTOR_KEY.getKey());
    root.add(fdStatus, 1, 5, 10, 1);

    ConfigButton odStatus = new ConfigButton("gui.apextended.config.buttons.oredetector", ConfigKeys.ORE_DETECTOR_KEY.getKey());
    root.add(odStatus, 12, 5, 10, 1);

    ConfigButton ldStatus = new ConfigButton("gui.apextended.config.buttons.lavadetector", ConfigKeys.LAVA_DETECTOR_KEY.getKey());
    root.add(ldStatus, 1, 7, 10, 1);

    ConfigButton wdStatus = new ConfigButton("gui.apextended.config.buttons.waterdetector", ConfigKeys.WATER_DETECTOR_KEY.getKey());
    root.add(wdStatus, 12, 7, 10, 1);

    ConfigButton dcStatus = new ConfigButton("gui.apextended.config.buttons.durabilitychecker", ConfigKeys.DURABILITY_CHECK_KEY.getKey());
    root.add(dcStatus, 1, 9, 10, 1);

    ArrayButton cnStatus = new ArrayButton("gui.apextended.config.buttons.chatnarration", ConfigKeys.CHAT_NARRATION.getKey(), NarratorPlus.chatOptions);
    root.add(cnStatus, 12, 9, 10, 1);

    WButton settingsButton = new WButton(new TranslatableText("gui.apextended.config.buttons.settings"));
    settingsButton.setOnClick(this::onSettingsClick);
    root.add(settingsButton, 2, 11, 7, 1);

    WButton doneButton = new WButton(new TranslatableText("gui.apextended.config.buttons.done"));
    doneButton.setOnClick(this::onDoneClick);
    root.add(doneButton, 12, 11, 7, 1);

    WLabel label = new WLabel(new LiteralText("Accessibility Plus Extended"), modInit.colors("red", 100));
    label.setHorizontalAlignment(HorizontalAlignment.CENTER);
    root.add(label, 0, 1, 21, 1);
    WLabel fakeLabel = new WLabel(new LiteralText(""), modInit.colors("red", 100));
    fakeLabel.setHorizontalAlignment(HorizontalAlignment.CENTER);
    root.add(fakeLabel, 0, 12, 21, 1);

    root.validate(this);
  }

  private void onDoneClick() {
    this.player.closeScreen();
  }

  private void onSettingsClick() {
    this.player.closeScreen();
    this.client.openScreen(new ConfigScreen(new SettingsGui(client.player, client), "Settings", player));
  }

  // private void hbClick(){
  // this.player.closeScreen();
  // this.client.openScreen(new ConfigScreen(new
  // HBConfigGui(client.player,client)));
  // }

  @Override
  public void addPainters() {
    this.rootPanel.setBackgroundPainter(BackgroundPainter.createColorful(modInit.colors("lightgrey", 50)));
  }

}
