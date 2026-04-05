/*
 * Copyright (c) 2014-2025 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.hack;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import net.wurstclient.Category;
import net.wurstclient.Feature;
import net.wurstclient.hacks.ClickGuiHack;
import net.wurstclient.hacks.NavigatorHack;
import net.wurstclient.hacks.TooManyHaxHack;

public abstract class Hack extends Feature
{
	private static final Map<String, String> CHINESE_NAMES = new HashMap<>();
	static
	{
		CHINESE_NAMES.put("AimAssist", "辅助瞄准");
		CHINESE_NAMES.put("AirPlace", "空中放置");
		CHINESE_NAMES.put("AnchorAura", "重生锚光环");
		CHINESE_NAMES.put("AntiAFK", "反挂机检测");
		CHINESE_NAMES.put("AntiBlind", "反失明");
		CHINESE_NAMES.put("AntiCactus", "反仙人掌");
		CHINESE_NAMES.put("AntiEntityPush", "反实体推动");
		CHINESE_NAMES.put("AntiHunger", "反饥饿");
		CHINESE_NAMES.put("AntiKnockback", "反击退");
		CHINESE_NAMES.put("AntiSpam", "反刷屏");
		CHINESE_NAMES.put("AntiWaterPush", "反水流推动");
		CHINESE_NAMES.put("AntiWobble", "反摇晃");
		CHINESE_NAMES.put("ArrowDmg", "箭矢增伤");
		CHINESE_NAMES.put("AutoArmor", "自动盔甲");
		CHINESE_NAMES.put("AutoBuild", "自动建造");
		CHINESE_NAMES.put("AutoComplete", "自动补全");
		CHINESE_NAMES.put("AutoDrop", "自动丢弃");
		CHINESE_NAMES.put("AutoEat", "自动进食");
		CHINESE_NAMES.put("AutoFarm", "自动农场");
		CHINESE_NAMES.put("AutoFish", "自动钓鱼");
		CHINESE_NAMES.put("AutoLeave", "自动退出");
		CHINESE_NAMES.put("AutoLibrarian", "自动图书管理员");
		CHINESE_NAMES.put("AutoMine", "自动挖矿");
		CHINESE_NAMES.put("AutoPotion", "自动药水");
		CHINESE_NAMES.put("AutoReconnect", "自动重连");
		CHINESE_NAMES.put("AutoRespawn", "自动重生");
		CHINESE_NAMES.put("AutoSign", "自动告示牌");
		CHINESE_NAMES.put("AutoSoup", "自动喝汤");
		CHINESE_NAMES.put("AutoSprint", "自动疾跑");
		CHINESE_NAMES.put("AutoSteal", "自动盗取");
		CHINESE_NAMES.put("AutoSwim", "自动游泳");
		CHINESE_NAMES.put("AutoSwitch", "自动切换");
		CHINESE_NAMES.put("AutoSword", "自动换剑");
		CHINESE_NAMES.put("AutoTool", "自动换工具");
		CHINESE_NAMES.put("AutoTotem", "自动图腾");
		CHINESE_NAMES.put("AutoWalk", "自动行走");
		CHINESE_NAMES.put("BarrierESP", "屏障透视");
		CHINESE_NAMES.put("BaseFinder", "基地搜索");
		CHINESE_NAMES.put("Blink", "闪现");
		CHINESE_NAMES.put("BoatFly", "船飞行");
		CHINESE_NAMES.put("BonemealAura", "骨粉光环");
		CHINESE_NAMES.put("BowAimbot", "弓箭自瞄");
		CHINESE_NAMES.put("BuildRandom", "随机建造");
		CHINESE_NAMES.put("BunnyHop", "兔子跳");
		CHINESE_NAMES.put("CameraDistance", "相机距离");
		CHINESE_NAMES.put("CameraNoClip", "相机穿墙");
		CHINESE_NAMES.put("CaveFinder", "洞穴搜索");
		CHINESE_NAMES.put("ChatTranslator", "聊天翻译");
		CHINESE_NAMES.put("ChestESP", "箱子透视");
		CHINESE_NAMES.put("ClickAura", "点击光环");
		CHINESE_NAMES.put("ClickGUI", "点击界面");
		CHINESE_NAMES.put("CrashChest", "崩溃箱子");
		CHINESE_NAMES.put("CreativeFlight", "创造飞行");
		CHINESE_NAMES.put("Criticals", "暴击");
		CHINESE_NAMES.put("CrystalAura", "水晶光环");
		CHINESE_NAMES.put("Derp", "抽搐");
		CHINESE_NAMES.put("Dolphin", "海豚");
		CHINESE_NAMES.put("Excavator", "挖掘机");
		CHINESE_NAMES.put("ExtraElytra", "鞘翅增强");
		CHINESE_NAMES.put("FancyChat", "花式聊天");
		CHINESE_NAMES.put("FastBreak", "快速破坏");
		CHINESE_NAMES.put("FastLadder", "快速爬梯");
		CHINESE_NAMES.put("FastPlace", "快速放置");
		CHINESE_NAMES.put("FeedAura", "喂食光环");
		CHINESE_NAMES.put("FightBot", "战斗机器人");
		CHINESE_NAMES.put("Fish", "鱼");
		CHINESE_NAMES.put("Flight", "飞行");
		CHINESE_NAMES.put("Follow", "跟随");
		CHINESE_NAMES.put("ForceOP", "强制OP");
		CHINESE_NAMES.put("Freecam", "灵魂出窍");
		CHINESE_NAMES.put("Fullbright", "满亮度");
		CHINESE_NAMES.put("Glide", "滑翔");
		CHINESE_NAMES.put("HandNoClip", "手臂穿墙");
		CHINESE_NAMES.put("HeadRoll", "摇头");
		CHINESE_NAMES.put("HealthTags", "血量标签");
		CHINESE_NAMES.put("HighJump", "高跳");
		CHINESE_NAMES.put("InfiniChat", "无限聊天");
		CHINESE_NAMES.put("InstaBuild", "瞬间建造");
		CHINESE_NAMES.put("InstantBunker", "瞬间碉堡");
		CHINESE_NAMES.put("InvWalk", "背包行走");
		CHINESE_NAMES.put("ItemESP", "物品透视");
		CHINESE_NAMES.put("ItemGenerator", "物品生成器");
		CHINESE_NAMES.put("Jesus", "水上行走");
		CHINESE_NAMES.put("Jetpack", "喷气背包");
		CHINESE_NAMES.put("Kaboom", "爆破");
		CHINESE_NAMES.put("KillauraLegit", "合法杀戮光环");
		CHINESE_NAMES.put("Killaura", "杀戮光环");
		CHINESE_NAMES.put("KillPotion", "致死药水");
		CHINESE_NAMES.put("Liquids", "液体放置");
		CHINESE_NAMES.put("LSD", "幻觉");
		CHINESE_NAMES.put("MassTPA", "批量TPA");
		CHINESE_NAMES.put("MileyCyrus", "疯狂蹲起");
		CHINESE_NAMES.put("MobESP", "生物透视");
		CHINESE_NAMES.put("MobSpawnESP", "刷怪点透视");
		CHINESE_NAMES.put("MultiAura", "多重光环");
		CHINESE_NAMES.put("NameProtect", "名称保护");
		CHINESE_NAMES.put("NameTags", "名称标签");
		CHINESE_NAMES.put("Navigator", "导航器");
		CHINESE_NAMES.put("NewChunks", "新区块");
		CHINESE_NAMES.put("NoBackground", "无背景");
		CHINESE_NAMES.put("NoClip", "穿墙");
		CHINESE_NAMES.put("NocomCrash", "崩溃攻击");
		CHINESE_NAMES.put("NoFall", "防摔落");
		CHINESE_NAMES.put("NoFireOverlay", "去火焰遮罩");
		CHINESE_NAMES.put("NoFog", "去迷雾");
		CHINESE_NAMES.put("NoHurtcam", "去受伤摇晃");
		CHINESE_NAMES.put("NoLevitation", "去漂浮");
		CHINESE_NAMES.put("NoOverlay", "去遮罩");
		CHINESE_NAMES.put("NoPumpkin", "去南瓜头");
		CHINESE_NAMES.put("NoShieldOverlay", "去盾牌遮罩");
		CHINESE_NAMES.put("NoSlowdown", "去减速");
		CHINESE_NAMES.put("NoVignette", "去晕影");
		CHINESE_NAMES.put("NoWeather", "去天气");
		CHINESE_NAMES.put("NoWeb", "去蛛网");
		CHINESE_NAMES.put("Nuker", "自动挖掘");
		CHINESE_NAMES.put("NukerLegit", "合法挖掘");
		CHINESE_NAMES.put("OpenWaterESP", "开放水域透视");
		CHINESE_NAMES.put("Overlay", "覆盖层");
		CHINESE_NAMES.put("Panic", "紧急关闭");
		CHINESE_NAMES.put("Parkour", "跑酷");
		CHINESE_NAMES.put("PlayerESP", "玩家透视");
		CHINESE_NAMES.put("PortalESP", "传送门透视");
		CHINESE_NAMES.put("PortalGUI", "传送门界面");
		CHINESE_NAMES.put("PotionSaver", "药水节省");
		CHINESE_NAMES.put("ProphuntESP", "躲猫猫透视");
		CHINESE_NAMES.put("Protect", "保护");
		CHINESE_NAMES.put("Radar", "雷达");
		CHINESE_NAMES.put("RainbowUI", "彩虹界面");
		CHINESE_NAMES.put("Reach", "延伸距离");
		CHINESE_NAMES.put("RemoteView", "远程视角");
		CHINESE_NAMES.put("Restock", "自动补货");
		CHINESE_NAMES.put("SafeWalk", "安全行走");
		CHINESE_NAMES.put("ScaffoldWalk", "脚手架");
		CHINESE_NAMES.put("Search", "搜索方块");
		CHINESE_NAMES.put("SkinDerp", "皮肤抽搐");
		CHINESE_NAMES.put("Sneak", "潜行");
		CHINESE_NAMES.put("SnowShoe", "雪地行走");
		CHINESE_NAMES.put("SpeedHack", "加速");
		CHINESE_NAMES.put("SpeedNuker", "快速挖掘");
		CHINESE_NAMES.put("Spider", "蜘蛛攀爬");
		CHINESE_NAMES.put("Step", "自动台阶");
		CHINESE_NAMES.put("TemplateTool", "模板工具");
		CHINESE_NAMES.put("Throw", "连续投掷");
		CHINESE_NAMES.put("Tillaura", "耕地光环");
		CHINESE_NAMES.put("Timer", "计时器");
		CHINESE_NAMES.put("Tired", "疲惫");
		CHINESE_NAMES.put("TooManyHax", "功能限制");
		CHINESE_NAMES.put("TP-Aura", "传送光环");
		CHINESE_NAMES.put("Trajectories", "轨迹预测");
		CHINESE_NAMES.put("TreeBot", "砍树机器人");
		CHINESE_NAMES.put("TriggerBot", "触发机器人");
		CHINESE_NAMES.put("TrollPotion", "恶搞药水");
		CHINESE_NAMES.put("TrueSight", "真实视觉");
		CHINESE_NAMES.put("Tunneller", "隧道机");
		CHINESE_NAMES.put("VeinMiner", "矿脉采掘");
		CHINESE_NAMES.put("X-Ray", "透视");
		CHINESE_NAMES.put("Changelog", "更新日志");
		CHINESE_NAMES.put("CleanUp", "清理服务器");
		CHINESE_NAMES.put("Disable Wurst", "禁用 Wurst");
		CHINESE_NAMES.put("HackList", "功能列表");
		CHINESE_NAMES.put("Keybinds", "快捷键");
		CHINESE_NAMES.put("LastServer", "上次服务器");
		CHINESE_NAMES.put("NoChatReports", "禁用聊天举报");
		CHINESE_NAMES.put("NoTelemetry", "禁用遥测");
		CHINESE_NAMES.put("Reconnect", "重新连接");
		CHINESE_NAMES.put("ServerFinder", "服务器搜索");
		CHINESE_NAMES.put("TabGUI", "标签界面");
		CHINESE_NAMES.put("Translations", "翻译");
		CHINESE_NAMES.put("VanillaSpoof", "伪装原版");
		CHINESE_NAMES.put("WikiDataExport", "Wiki数据导出");
		CHINESE_NAMES.put("WurstCapes", "Wurst披风");
		CHINESE_NAMES.put("WurstLogo", "Wurst标志");
		CHINESE_NAMES.put("Zoom", "缩放");
	}

	public static String getChineseName(String englishName)
	{
		return CHINESE_NAMES.getOrDefault(englishName, englishName);
	}
	
	private final String name;
	private final String description;
	private Category category;
	
	private boolean enabled;
	private final boolean stateSaved =
		!getClass().isAnnotationPresent(DontSaveState.class);
	
	public Hack(String name)
	{
		this.name = Objects.requireNonNull(name);
		description = "description.wurst.hack." + name.toLowerCase();
		addPossibleKeybind(name, "Toggle " + name);
	}
	
	@Override
	public final String getName()
	{
		return name;
	}
	
	public String getDisplayName()
	{
		return getChineseName(name);
	}
	
	public String getRenderName()
	{
		return getChineseName(name);
	}
	
	@Override
	public final String getDescription()
	{
		return WURST.translate(description);
	}
	
	public final String getDescriptionKey()
	{
		return description;
	}
	
	@Override
	public final Category getCategory()
	{
		return category;
	}
	
	protected final void setCategory(Category category)
	{
		this.category = category;
	}
	
	@Override
	public final boolean isEnabled()
	{
		return enabled;
	}
	
	public final void setEnabled(boolean enabled)
	{
		if(this.enabled == enabled)
			return;
		
		TooManyHaxHack tooManyHax = WURST.getHax().tooManyHaxHack;
		if(enabled && tooManyHax.isEnabled() && tooManyHax.isBlocked(this))
			return;
		
		this.enabled = enabled;
		
		if(!(this instanceof NavigatorHack || this instanceof ClickGuiHack))
			WURST.getHud().getHackList().updateState(this);
		
		if(enabled)
			onEnable();
		else
			onDisable();
		
		if(stateSaved)
			WURST.getHax().saveEnabledHax();
	}
	
	@Override
	public final String getPrimaryAction()
	{
		return enabled ? "禁用" : "启用";
	}
	
	@Override
	public final void doPrimaryAction()
	{
		setEnabled(!enabled);
	}
	
	public final boolean isStateSaved()
	{
		return stateSaved;
	}
	
	protected void onEnable()
	{
		
	}
	
	protected void onDisable()
	{
		
	}
}
