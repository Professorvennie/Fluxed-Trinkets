package com.jared.electrifiedtrinkets.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

import com.jared.electrifiedtrinkets.blocks.BlockSolderingStation;
import com.jared.electrifiedtrinkets.client.render.gui.GuiSolderingStationCircuit;
import com.jared.electrifiedtrinkets.items.ETItems;
import com.jared.electrifiedtrinkets.tileEntity.TileEntitySolderingStation;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MessageSolderingStation implements IMessage, IMessageHandler<MessageSolderingStation, IMessage> {
	public MessageSolderingStation() {
	}

	private int x, y, z;

	public MessageSolderingStation(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.x = buf.readInt();
		this.y = buf.readInt();
		this.z = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(x);
		buf.writeInt(y);
		buf.writeInt(z);
	}

	@Override
	public IMessage onMessage(MessageSolderingStation message, MessageContext ctx) {
		
//		GuiScreen gui = Minecraft.getMinecraft().currentScreen;
//		
//		if(gui !=null && gui instanceof GuiSolderingStationCircuit){
//			GuiSolderingStationCircuit solderingStation = (GuiSolderingStationCircuit)gui;
//			
//			
//		}
		
		
		EntityPlayer entity = Minecraft.getMinecraft().thePlayer;

		Block solderingStation = entity.worldObj.getBlock(message.x, message.y, message.z);

		if (solderingStation instanceof BlockSolderingStation) {

			TileEntitySolderingStation tile = (TileEntitySolderingStation) entity.worldObj.getTileEntity(message.x, message.y, message.z);
				tile.setInventorySlotContents(0, new ItemStack(ETItems.solderingIron));
		}
		return null;
	}
}