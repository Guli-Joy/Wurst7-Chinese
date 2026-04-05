/*
 * Copyright (c) 2014-2025 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.settings;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.wurstclient.clickgui.Component;
import net.wurstclient.keybinds.PossibleKeybind;
import net.wurstclient.util.ChatUtils;
import net.wurstclient.util.text.WText;

public abstract class Setting
{
	private final String name;
	private final WText description;

	private static final Map<String, String> DISPLAY_NAMES = new HashMap<>();
	static
	{
		// Common settings
		DISPLAY_NAMES.put("Range", "范围");
		DISPLAY_NAMES.put("Speed", "速度");
		DISPLAY_NAMES.put("Mode", "模式");
		DISPLAY_NAMES.put("Delay", "延迟");
		DISPLAY_NAMES.put("Health", "生命值");
		DISPLAY_NAMES.put("Radius", "半径");
		DISPLAY_NAMES.put("Distance", "距离");
		DISPLAY_NAMES.put("Height", "高度");
		DISPLAY_NAMES.put("Limit", "限制");
		DISPLAY_NAMES.put("Power", "力量");
		DISPLAY_NAMES.put("Scale", "缩放");
		DISPLAY_NAMES.put("Opacity", "不透明度");
		DISPLAY_NAMES.put("Slot", "槽位");
		DISPLAY_NAMES.put("Status", "状态");
		DISPLAY_NAMES.put("Priority", "优先级");
		DISPLAY_NAMES.put("Offset", "偏移");
		DISPLAY_NAMES.put("Items", "物品");
		DISPLAY_NAMES.put("Template", "模板");
		DISPLAY_NAMES.put("Text", "文字");
		DISPLAY_NAMES.put("Time", "时间");
		DISPLAY_NAMES.put("Sound", "声音");
		DISPLAY_NAMES.put("Particles", "粒子");
		DISPLAY_NAMES.put("Packets", "数据包");
		DISPLAY_NAMES.put("Fade", "淡出");
		DISPLAY_NAMES.put("Position", "位置");
		DISPLAY_NAMES.put("Keybind", "快捷键");
		DISPLAY_NAMES.put("Guide", "引导");
		DISPLAY_NAMES.put("Guide color", "引导颜色");
		DISPLAY_NAMES.put("Tracer", "追踪线");
		DISPLAY_NAMES.put("Tracer color", "追踪线颜色");
		DISPLAY_NAMES.put("Other", "其他");
		DISPLAY_NAMES.put("FOV", "视野角度");
		DISPLAY_NAMES.put("Ores", "矿石");
		DISPLAY_NAMES.put("Indicator", "指示器");
		DISPLAY_NAMES.put("Saplings", "树苗");
		DISPLAY_NAMES.put("Stems", "菌柄");
		DISPLAY_NAMES.put("Totems", "图腾");
		DISPLAY_NAMES.put("Visibility", "可见性");
		// Slider settings
		DISPLAY_NAMES.put("Horizontal Speed", "水平速度");
		DISPLAY_NAMES.put("Vertical Speed", "垂直速度");
		DISPLAY_NAMES.put("Horizontal Strength", "水平力度");
		DISPLAY_NAMES.put("Vertical Strength", "垂直力度");
		DISPLAY_NAMES.put("Forward Speed", "前进速度");
		DISPLAY_NAMES.put("Upward Speed", "向上速度");
		DISPLAY_NAMES.put("Rotation Speed", "旋转速度");
		DISPLAY_NAMES.put("Move speed", "移动速度");
		DISPLAY_NAMES.put("Fall speed", "下落速度");
		DISPLAY_NAMES.put("Twerk speed", "蹲起速度");
		DISPLAY_NAMES.put("Edge distance", "边缘距离");
		DISPLAY_NAMES.put("Draw distance", "绘制距离");
		DISPLAY_NAMES.put("Zoom level", "缩放级别");
		DISPLAY_NAMES.put("Max height", "最大高度");
		DISPLAY_NAMES.put("Min height", "最小高度");
		DISPLAY_NAMES.put("Max settings height", "最大设置高度");
		DISPLAY_NAMES.put("Max tokens", "最大令牌数");
		DISPLAY_NAMES.put("Max attempts", "最大尝试次数");
		DISPLAY_NAMES.put("Max vein size", "最大矿脉大小");
		DISPLAY_NAMES.put("Max suggestions kept", "最大保留建议数");
		DISPLAY_NAMES.put("Max suggestions per draft", "每次草稿最大建议数");
		DISPLAY_NAMES.put("Max suggestions shown", "最大显示建议数");
		DISPLAY_NAMES.put("Stack size", "堆叠大小");
		DISPLAY_NAMES.put("Minimum amount", "最小数量");
		DISPLAY_NAMES.put("Min depth", "最小深度");
		DISPLAY_NAMES.put("Min hunger", "最小饥饿值");
		DISPLAY_NAMES.put("Release time", "释放时间");
		DISPLAY_NAMES.put("Retry delay", "重试延迟");
		DISPLAY_NAMES.put("Tooltip opacity", "工具提示不透明度");
		DISPLAY_NAMES.put("Temperature", "温度");
		DISPLAY_NAMES.put("Frequency penalty", "频率惩罚");
		DISPLAY_NAMES.put("Presence penalty", "存在惩罚");
		DISPLAY_NAMES.put("Wait time", "等待时间");
		DISPLAY_NAMES.put("Wait time randomization", "等待时间随机化");
		DISPLAY_NAMES.put("Speed randomization", "速度随机化");
		DISPLAY_NAMES.put("Non-blocking offset", "非阻挡偏移");
		DISPLAY_NAMES.put("Injured hunger", "受伤饥饿值");
		DISPLAY_NAMES.put("Injury threshold", "受伤阈值");
		DISPLAY_NAMES.put("Target hunger", "目标饥饿值");
		DISPLAY_NAMES.put("Tunnel size", "隧道大小");
		DISPLAY_NAMES.put("Sneak edge distance", "潜行边缘距离");
		DISPLAY_NAMES.put("Patience", "耐心值");
		DISPLAY_NAMES.put("Valid range", "有效范围");
		DISPLAY_NAMES.put("Non-AI range", "非AI范围");
		DISPLAY_NAMES.put("mcMMO range", "mcMMO范围");
		DISPLAY_NAMES.put("mcMMO limit", "mcMMO限制");
		// Checkbox settings
		DISPLAY_NAMES.put("Legit mode", "合法模式");
		DISPLAY_NAMES.put("Debug mode", "调试模式");
		DISPLAY_NAMES.put("Flat mode", "平面模式");
		DISPLAY_NAMES.put("See-through mode", "透视模式");
		DISPLAY_NAMES.put("Repair mode", "修复模式");
		DISPLAY_NAMES.put("Super fast mode", "超快模式");
		DISPLAY_NAMES.put("RC mode", "RC模式");
		DISPLAY_NAMES.put("mcMMO mode", "mcMMO模式");
		DISPLAY_NAMES.put("Trident yeet mode", "三叉戟投掷模式");
		DISPLAY_NAMES.put("Instant fly", "瞬间飞行");
		DISPLAY_NAMES.put("Height control", "高度控制");
		DISPLAY_NAMES.put("Speed control", "速度控制");
		DISPLAY_NAMES.put("Predict movement", "预测移动");
		DISPLAY_NAMES.put("Simulate mouse click", "模拟鼠标点击");
		DISPLAY_NAMES.put("Swing hand", "挥动手臂");
		DISPLAY_NAMES.put("Replant", "重新种植");
		DISPLAY_NAMES.put("Place torches", "放置火把");
		DISPLAY_NAMES.put("Eat while walking", "行走时进食");
		DISPLAY_NAMES.put("Use AI", "使用AI");
		DISPLAY_NAMES.put("Use AI (experimental)", "使用AI（实验性）");
		DISPLAY_NAMES.put("Use enchantments", "使用附魔");
		DISPLAY_NAMES.put("Use hands", "使用手");
		DISPLAY_NAMES.put("Use swords", "使用剑");
		DISPLAY_NAMES.put("Use mouse wheel", "使用鼠标滚轮");
		DISPLAY_NAMES.put("Use saved blocks", "使用保存的方块");
		DISPLAY_NAMES.put("Strict build order", "严格建造顺序");
		DISPLAY_NAMES.put("Natural Blocks", "自然方块");
		DISPLAY_NAMES.put("Place while breaking", "破坏时放置");
		DISPLAY_NAMES.put("Place while riding", "骑乘时放置");
		DISPLAY_NAMES.put("Unlimited range", "无限范围");
		DISPLAY_NAMES.put("Prevent slowdown", "防止减速");
		DISPLAY_NAMES.put("Hungry Sprint", "饥饿疾跑");
		DISPLAY_NAMES.put("Omnidirectional Sprint", "全方向疾跑");
		DISPLAY_NAMES.put("Jump while sneaking", "潜行时跳跃");
		DISPLAY_NAMES.put("Slow sneaking", "缓慢潜行");
		DISPLAY_NAMES.put("Sneak at edges", "边缘潜行");
		DISPLAY_NAMES.put("Rotate with player", "跟随玩家旋转");
		DISPLAY_NAMES.put("Only show exposed", "仅显示暴露的");
		DISPLAY_NAMES.put("Depth test", "深度测试");
		DISPLAY_NAMES.put("Debug draw", "调试绘制");
		DISPLAY_NAMES.put("Show counter", "显示计数器");
		DISPLAY_NAMES.put("Show totem counter", "显示图腾计数器");
		DISPLAY_NAMES.put("Show wait time", "显示等待时间");
		DISPLAY_NAMES.put("Show reasons", "显示原因");
		DISPLAY_NAMES.put("Lock ID", "锁定ID");
		DISPLAY_NAMES.put("Lock in trade", "锁定交易");
		DISPLAY_NAMES.put("Switch back", "切换回来");
		DISPLAY_NAMES.put("Swap while moving", "移动时切换");
		DISPLAY_NAMES.put("Log chunks", "记录区块");
		DISPLAY_NAMES.put("Stop when accepted", "接受时停止");
		DISPLAY_NAMES.put("Stop when inv full", "背包满时停止");
		DISPLAY_NAMES.put("Stop when out of rods", "没有鱼竿时停止");
		DISPLAY_NAMES.put("Turn off while flying", "飞行时关闭");
		DISPLAY_NAMES.put("Pause when sneaking", "潜行时暂停");
		DISPLAY_NAMES.put("Reverse sorting", "反向排序");
		DISPLAY_NAMES.put("Reverse steal order", "反向盗取顺序");
		DISPLAY_NAMES.put("Ignore errors", "忽略错误");
		DISPLAY_NAMES.put("Ignore mouse input", "忽略鼠标输入");
		DISPLAY_NAMES.put("Zoom in screens", "在屏幕中缩放");
		DISPLAY_NAMES.put("Disable AutoReconnect", "禁用自动重连");
		DISPLAY_NAMES.put("Disable Freecam", "禁用灵魂出窍");
		DISPLAY_NAMES.put("Disable signatures", "禁用签名");
		DISPLAY_NAMES.put("Disable telemetry", "禁用遥测");
		DISPLAY_NAMES.put("Disable Rain", "禁用雨");
		DISPLAY_NAMES.put("Death screen button", "死亡屏幕按钮");
		DISPLAY_NAMES.put("Hide enable button", "隐藏启用按钮");
		DISPLAY_NAMES.put("Steal/Store buttons", "盗取/存储按钮");
		DISPLAY_NAMES.put("Force English", "强制英语");
		DISPLAY_NAMES.put("Spoof Vanilla", "伪装原版");
		DISPLAY_NAMES.put("Middle click friends", "中键点击好友");
		DISPLAY_NAMES.put("NoCheat+ bypass", "NoCheat+绕过");
		DISPLAY_NAMES.put("mcMMO range bug", "mcMMO范围漏洞");
		DISPLAY_NAMES.put("MultiTill", "多重耕地");
		DISPLAY_NAMES.put("Stop sequence", "停止序列");
		DISPLAY_NAMES.put("Wanted books", "需要的书");
		DISPLAY_NAMES.put("Moon Phase", "月相");
		DISPLAY_NAMES.put("Default brightness", "默认亮度");
		DISPLAY_NAMES.put("Sort by", "排序方式");
		DISPLAY_NAMES.put("Potion type", "药水类型");
		DISPLAY_NAMES.put("Tools repair mode", "工具修复模式");
		DISPLAY_NAMES.put("Allow elytra", "允许鞘翅");
		// Filter settings
		DISPLAY_NAMES.put("Filter players", "过滤玩家");
		DISPLAY_NAMES.put("Filter sleeping", "过滤睡觉的");
		DISPLAY_NAMES.put("Filter flying", "过滤飞行的");
		DISPLAY_NAMES.put("Filter monsters", "过滤怪物");
		DISPLAY_NAMES.put("Filter animals", "过滤动物");
		DISPLAY_NAMES.put("Filter babies", "过滤幼崽");
		DISPLAY_NAMES.put("Filter pets", "过滤宠物");
		DISPLAY_NAMES.put("Filter traders", "过滤商人");
		DISPLAY_NAMES.put("Filter golems", "过滤傀儡");
		DISPLAY_NAMES.put("Filter invisible", "过滤隐身的");
		DISPLAY_NAMES.put("Filter named", "过滤命名的");
		DISPLAY_NAMES.put("Filter armor stands", "过滤盔甲架");
		DISPLAY_NAMES.put("Filter shulkers", "过滤潜影贝");
		DISPLAY_NAMES.put("Filter allays", "过滤悦灵");
		DISPLAY_NAMES.put("Filter endermen", "过滤末影人");
		DISPLAY_NAMES.put("Filter piglins", "过滤猪灵");
		DISPLAY_NAMES.put("Filter zombie piglins", "过滤僵尸猪灵");
		DISPLAY_NAMES.put("Filter villagers", "过滤村民");
		DISPLAY_NAMES.put("Filter zombie villagers", "过滤僵尸村民");
		DISPLAY_NAMES.put("Filter bats", "过滤蝙蝠");
		DISPLAY_NAMES.put("Filter slimes", "过滤史莱姆");
		DISPLAY_NAMES.put("Filter neutral", "过滤中立生物");
		DISPLAY_NAMES.put("Filter water", "过滤水生生物");
		DISPLAY_NAMES.put("Filter minecarts", "过滤矿车");
		DISPLAY_NAMES.put("Filter horse-like animals", "过滤马类动物");
		DISPLAY_NAMES.put("Filter untamed", "过滤未驯服的");
		DISPLAY_NAMES.put("Filter server messages", "过滤服务器消息");
		DISPLAY_NAMES.put("Filter own messages", "过滤自己的消息");
		// Color settings
		DISPLAY_NAMES.put("Background", "背景");
		DISPLAY_NAMES.put("Accent", "强调色");
		DISPLAY_NAMES.put("ESP color", "透视颜色");
		DISPLAY_NAMES.put("Night color", "夜间颜色");
		DISPLAY_NAMES.put("Day color", "日间颜色");
		DISPLAY_NAMES.put("Miss Color", "未命中颜色");
		DISPLAY_NAMES.put("Entity Hit Color", "实体命中颜色");
		DISPLAY_NAMES.put("New chunks color", "新区块颜色");
		DISPLAY_NAMES.put("Old chunks color", "旧区块颜色");
		DISPLAY_NAMES.put("Chest color", "箱子颜色");
		DISPLAY_NAMES.put("Trap chest color", "陷阱箱颜色");
		DISPLAY_NAMES.put("Ender color", "末影箱颜色");
		DISPLAY_NAMES.put("Shulker color", "潜影盒颜色");
		DISPLAY_NAMES.put("Barrel color", "木桶颜色");
		DISPLAY_NAMES.put("Hopper color", "漏斗颜色");
		DISPLAY_NAMES.put("Hopper cart color", "漏斗矿车颜色");
		DISPLAY_NAMES.put("Dropper color", "投掷器颜色");
		DISPLAY_NAMES.put("Dispenser color", "发射器颜色");
		DISPLAY_NAMES.put("Furnace color", "熔炉颜色");
		DISPLAY_NAMES.put("Nether portal color", "下界传送门颜色");
		DISPLAY_NAMES.put("End portal color", "末地传送门颜色");
		DISPLAY_NAMES.put("End portal frame color", "末地传送门框架颜色");
		DISPLAY_NAMES.put("End gateway color", "末地折跃门颜色");
		// Include settings
		DISPLAY_NAMES.put("Include barrels", "包含木桶");
		DISPLAY_NAMES.put("Include chest boats", "包含运输船");
		DISPLAY_NAMES.put("Include chest carts", "包含运输矿车");
		DISPLAY_NAMES.put("Include dispensers", "包含发射器");
		DISPLAY_NAMES.put("Include droppers", "包含投掷器");
		DISPLAY_NAMES.put("Include end gateways", "包含末地折跃门");
		DISPLAY_NAMES.put("Include end portal frames", "包含末地传送门框架");
		DISPLAY_NAMES.put("Include end portals", "包含末地传送门");
		DISPLAY_NAMES.put("Include ender chests", "包含末影箱");
		DISPLAY_NAMES.put("Include furnaces", "包含熔炉");
		DISPLAY_NAMES.put("Include hopper carts", "包含漏斗矿车");
		DISPLAY_NAMES.put("Include hoppers", "包含漏斗");
		DISPLAY_NAMES.put("Include nether portals", "包含下界传送门");
		DISPLAY_NAMES.put("Include shulkers", "包含潜影盒");
		DISPLAY_NAMES.put("Include trap chests", "包含陷阱箱");
		// ChatTranslator
		DISPLAY_NAMES.put("Your language", "你的语言");
		DISPLAY_NAMES.put("Other language", "对方语言");
		DISPLAY_NAMES.put("Detect received language", "检测接收语言");
		DISPLAY_NAMES.put("Detect sent language", "检测发送语言");
		// AI settings
		DISPLAY_NAMES.put("OpenAI model", "OpenAI模型");
		DISPLAY_NAMES.put("OpenAI chat endpoint", "OpenAI聊天端点");
		DISPLAY_NAMES.put("OpenAI legacy endpoint", "OpenAI传统端点");
		// Specific hack settings
		DISPLAY_NAMES.put("Take items from", "从...获取物品");
		DISPLAY_NAMES.put("Aim at", "瞄准位置");
		DISPLAY_NAMES.put("Check line of sight", "检查视线");
		DISPLAY_NAMES.put("Aim while blocking", "格挡时瞄准");
		DISPLAY_NAMES.put("Auto-place anchors", "自动放置锚");
		DISPLAY_NAMES.put("Face anchors", "面向锚");
		DISPLAY_NAMES.put("Hitbox check", "碰撞箱检查");
		// Additional settings
		DISPLAY_NAMES.put("Altitude", "高度");
		DISPLAY_NAMES.put("Amount", "数量");
		DISPLAY_NAMES.put("Area", "区域");
		DISPLAY_NAMES.put("Block", "方块");
		DISPLAY_NAMES.put("Color", "颜色");
		DISPLAY_NAMES.put("All GUIs", "所有界面");
		DISPLAY_NAMES.put("Blocking offset", "格挡偏移");
		DISPLAY_NAMES.put("Change Moon Phase", "更改月相");
		DISPLAY_NAMES.put("Change World Time", "更改世界时间");
		DISPLAY_NAMES.put("Attack while blocking", "格挡时攻击");
		DISPLAY_NAMES.put("Always show player names", "始终显示玩家名称");
		DISPLAY_NAMES.put("Context length", "上下文长度");
		DISPLAY_NAMES.put("Custom model", "自定义模型");
		DISPLAY_NAMES.put("Custom model type", "自定义模型类型");
		DISPLAY_NAMES.put("DD color", "调试绘制颜色");
		DISPLAY_NAMES.put("Always FastPlace", "始终快速放置");
		DISPLAY_NAMES.put("Allow chorus fruit", "允许紫颂果");
		DISPLAY_NAMES.put("Allow hunger effect", "允许饥饿效果");
		DISPLAY_NAMES.put("Allow offhand", "允许副手");
		DISPLAY_NAMES.put("Allow poison effect", "允许中毒效果");
		DISPLAY_NAMES.put("Allow ClickGUI", "允许点击界面");
		DISPLAY_NAMES.put("Allow jump key", "允许跳跃键");
		DISPLAY_NAMES.put("Allow other screens", "允许其他屏幕");
		DISPLAY_NAMES.put("Allow sneak key", "允许潜行键");
		DISPLAY_NAMES.put("Allow sprint key", "允许疾跑键");
		DISPLAY_NAMES.put("Anti-Kick", "防踢出");
		DISPLAY_NAMES.put("Anti-Kick Distance", "防踢出距离");
		DISPLAY_NAMES.put("Anti-Kick Interval", "防踢出间隔");
		DISPLAY_NAMES.put("Activation chance", "激活概率");
		DISPLAY_NAMES.put("Auto-place crystals", "自动放置水晶");
		DISPLAY_NAMES.put("Automation", "自动化");
		DISPLAY_NAMES.put("Always show named mobs", "始终显示命名生物");
		DISPLAY_NAMES.put("Bite mode", "咬钩模式");
		DISPLAY_NAMES.put("Blocks", "方块");
		DISPLAY_NAMES.put("Catch delay", "捕获延迟");
		DISPLAY_NAMES.put("Change Forward Speed", "改变前进速度");
		DISPLAY_NAMES.put("Check held item", "检查手持物品");
		DISPLAY_NAMES.put("Chest boat color", "运输船颜色");
		DISPLAY_NAMES.put("Chest cart color", "运输矿车颜色");
		DISPLAY_NAMES.put("Cocoa", "可可豆");
		DISPLAY_NAMES.put("Crops", "农作物");
		DISPLAY_NAMES.put("Command", "命令");
		DISPLAY_NAMES.put("Damage indicator", "伤害指示器");
		DISPLAY_NAMES.put("Jump if", "跳跃条件");
		DISPLAY_NAMES.put("Method", "方式");
		DISPLAY_NAMES.put("Stop flying in water", "在水中停止飞行");
	}
	
	public final String getDisplayName()
	{
		return DISPLAY_NAMES.getOrDefault(name, name);
	}

	public Setting(String name, WText description)
	{
		this.name = Objects.requireNonNull(name);
		this.description = Objects.requireNonNull(description);
	}
	
	public final String getName()
	{
		return name;
	}
	
	public final String getDescription()
	{
		return description.toString();
	}
	
	public final String getWrappedDescription(int width)
	{
		return ChatUtils.wrapText(getDescription(), width);
	}
	
	public abstract Component getComponent();
	
	public abstract void fromJson(JsonElement json);
	
	public abstract JsonElement toJson();
	
	/**
	 * Exports this setting's data to a {@link JsonObject} for use in the
	 * Wurst Wiki. Must always specify the following properties:
	 * <ul>
	 * <li>name
	 * <li>description
	 * <li>type
	 * </ul>
	 */
	public abstract JsonObject exportWikiData();
	
	public void update()
	{
		
	}
	
	public abstract Set<PossibleKeybind> getPossibleKeybinds(
		String featureName);
}
