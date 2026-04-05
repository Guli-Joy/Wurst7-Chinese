/*
 * Copyright (c) 2014-2025 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.options;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import net.fabricmc.fabric.api.client.screen.v1.Screens;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.util.Util.OperatingSystem;
import net.wurstclient.WurstClient;
import net.wurstclient.analytics.PlausibleAnalytics;
import net.wurstclient.commands.FriendsCmd;
import net.wurstclient.hacks.XRayHack;
import net.wurstclient.other_features.VanillaSpoofOtf;
import net.wurstclient.settings.CheckboxSetting;
import net.wurstclient.util.ChatUtils;

public class WurstOptionsScreen extends Screen
{
	private Screen prevScreen;
	
	public WurstOptionsScreen(Screen prevScreen)
	{
		super(Text.literal(""));
		this.prevScreen = prevScreen;
	}
	
	@Override
	public void init()
	{
		addDrawableChild(ButtonWidget
			.builder(Text.literal("返回"), b -> client.setScreen(prevScreen))
			.dimensions(width / 2 - 100, height / 4 + 144 - 16, 200, 20)
			.build());
		
		addSettingButtons();
		addManagerButtons();
		addLinkButtons();
	}
	
	private void addSettingButtons()
	{
		WurstClient wurst = WurstClient.INSTANCE;
		FriendsCmd friendsCmd = wurst.getCmds().friendsCmd;
		CheckboxSetting middleClickFriends = friendsCmd.getMiddleClickFriends();
		PlausibleAnalytics plausible = wurst.getPlausible();
		VanillaSpoofOtf vanillaSpoofOtf = wurst.getOtfs().vanillaSpoofOtf;
		CheckboxSetting forceEnglish =
			wurst.getOtfs().translationsOtf.getForceEnglish();
		
		new WurstOptionsButton(-154, 24,
			() -> "点击好友: "
				+ (middleClickFriends.isChecked() ? "开" : "关"),
			middleClickFriends.getWrappedDescription(200),
			b -> middleClickFriends
				.setChecked(!middleClickFriends.isChecked()));
		
		new WurstOptionsButton(-154, 48,
			() -> "用户统计: " + (plausible.isEnabled() ? "开" : "关"),
			"统计有多少人在使用 Wurst 以及哪些版本最受欢迎。"
				+ " 这些数据帮助开发者决定何时停止"
				+ " 支持旧版本。\n\n"
				+ "这些统计完全匿名，不会被出售，"
				+ " 且保存在欧盟（开发者在德国自托管 Plausible）。"
				+ " 没有 Cookie 或持久标识符"
				+ "（参见 plausible.io）。",
			b -> plausible.setEnabled(!plausible.isEnabled()));
		
		new WurstOptionsButton(-154, 72,
			() -> "伪装原版: "
				+ (vanillaSpoofOtf.isEnabled() ? "开" : "关"),
			vanillaSpoofOtf.getDescription(),
			b -> vanillaSpoofOtf.doPrimaryAction());
		
		new WurstOptionsButton(-154, 96,
			() -> "翻译: " + (!forceEnglish.isChecked() ? "开" : "关"),
			"允许 Wurst 中的文字以其他语言显示。"
				+ " 它将使用与 Minecraft 相同的语言"
				+ " 设置。\n\n这是一个实验性功能！",
			b -> forceEnglish.setChecked(!forceEnglish.isChecked()));
	}
	
	private void addManagerButtons()
	{
		XRayHack xRayHack = WurstClient.INSTANCE.getHax().xRayHack;
		
		new WurstOptionsButton(-50, 24, () -> "快捷键",
			"快捷键允许你只需按下按钮即可"
				+ " 切换任何功能或命令。",
			b -> client.setScreen(new KeybindManagerScreen(this)));
		
		new WurstOptionsButton(-50, 48, () -> "透视方块",
			"管理透视功能显示的方块。",
			b -> xRayHack.openBlockListEditor(this));
		
		new WurstOptionsButton(-50, 72, () -> "缩放",
			"缩放管理器允许你更改缩放键和"
				+ " 缩放倍数。",
			b -> client.setScreen(new ZoomManagerScreen(this)));
	}
	
	private void addLinkButtons()
	{
		OperatingSystem os = Util.getOperatingSystem();
		
		new WurstOptionsButton(54, 24, () -> "官方网站",
			"§n§lWurstClient.net",
			b -> os.open("https://www.wurstclient.net/options-website/"));
		
		new WurstOptionsButton(54, 48, () -> "Wurst百科", "§n§lWurst.Wiki",
			b -> os.open("https://www.wurstclient.net/options-wiki/"));
		
		new WurstOptionsButton(54, 72, () -> "Wurst论坛", "§n§lWurstForum.net",
			b -> os.open("https://www.wurstclient.net/options-forum/"));
		
		new WurstOptionsButton(54, 96, () -> "推特", "@Wurst_Imperium",
			b -> os.open("https://www.wurstclient.net/options-twitter/"));
		
		new WurstOptionsButton(54, 120, () -> "捐赠",
			"§n§lWurstClient.net/donate\n"
				+ "捐赠以帮助开发者维持 Wurst Client 的运营"
				+ " 并保持对所有人免费。\n\n"
				+ "每一点帮助都非常感谢！你还可以"
				+ " 获得一些很酷的回报。",
			b -> os.open("https://www.wurstclient.net/options-donate/"));
	}
	
	@Override
	public void close()
	{
		client.setScreen(prevScreen);
	}
	
	@Override
	public void render(DrawContext context, int mouseX, int mouseY,
		float partialTicks)
	{
		renderBackground(context);
		renderTitles(context);
		super.render(context, mouseX, mouseY, partialTicks);
		renderButtonTooltip(context, mouseX, mouseY);
	}
	
	private void renderTitles(DrawContext context)
	{
		TextRenderer tr = client.textRenderer;
		int middleX = width / 2;
		int y1 = 40;
		int y2 = height / 4 + 24 - 28;
		
		context.drawCenteredTextWithShadow(tr, "Wurst 选项", middleX, y1,
			0xffffff);
		
		context.drawCenteredTextWithShadow(tr, "设置", middleX - 104, y2,
			0xcccccc);
		context.drawCenteredTextWithShadow(tr, "管理器", middleX, y2,
			0xcccccc);
		context.drawCenteredTextWithShadow(tr, "链接", middleX + 104, y2,
			0xcccccc);
	}
	
	private void renderButtonTooltip(DrawContext context, int mouseX,
		int mouseY)
	{
		for(ClickableWidget button : Screens.getButtons(this))
		{
			if(!button.isSelected() || !(button instanceof WurstOptionsButton))
				continue;
			
			WurstOptionsButton woButton = (WurstOptionsButton)button;
			
			if(woButton.tooltip.isEmpty())
				continue;
			
			context.drawTooltip(textRenderer, woButton.tooltip, mouseX, mouseY);
			break;
		}
	}
	
	private final class WurstOptionsButton extends ButtonWidget
	{
		private final Supplier<String> messageSupplier;
		private final List<Text> tooltip;
		
		public WurstOptionsButton(int xOffset, int yOffset,
			Supplier<String> messageSupplier, String tooltip,
			PressAction pressAction)
		{
			super(WurstOptionsScreen.this.width / 2 + xOffset,
				WurstOptionsScreen.this.height / 4 - 16 + yOffset, 100, 20,
				Text.literal(messageSupplier.get()), pressAction,
				ButtonWidget.DEFAULT_NARRATION_SUPPLIER);
			
			this.messageSupplier = messageSupplier;
			
			if(tooltip.isEmpty())
				this.tooltip = Arrays.asList();
			else
			{
				String[] lines = ChatUtils.wrapText(tooltip, 200).split("\n");
				
				Text[] lines2 = new Text[lines.length];
				for(int i = 0; i < lines.length; i++)
					lines2[i] = Text.literal(lines[i]);
				
				this.tooltip = Arrays.asList(lines2);
			}
			
			addDrawableChild(this);
		}
		
		@Override
		public void onPress()
		{
			super.onPress();
			setMessage(Text.literal(messageSupplier.get()));
		}
	}
}
