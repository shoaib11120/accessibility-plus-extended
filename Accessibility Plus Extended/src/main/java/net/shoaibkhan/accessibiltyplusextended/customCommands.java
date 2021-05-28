package net.shoaibkhan.accessibiltyplusextended;

import com.mojang.brigadier.CommandDispatcher;

import io.github.cottonmc.clientcommands.ArgumentBuilders;
import io.github.cottonmc.clientcommands.ClientCommandPlugin;
import io.github.cottonmc.clientcommands.CottonClientCommandSource;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;

public class customCommands implements ClientCommandPlugin {
	MinecraftClient client;
	
	@Override
	public void registerCommands(CommandDispatcher<CottonClientCommandSource> dispatcher) {
		dispatcher.register(ArgumentBuilders.literal("getxp").executes(
            source -> {
            	client = MinecraftClient.getInstance();
            	client.player.sendMessage(new LiteralText(""+client.player.experienceLevel), true);
                return 1;
            }
        ));
		
		dispatcher.register(ArgumentBuilders.literal("isfullscreen").executes(
            source -> {
            	client = MinecraftClient.getInstance();
            	client.player.sendMessage(new LiteralText(""+client.options.fullscreen), true);
                return 1;
            }
        ));
	}

}
