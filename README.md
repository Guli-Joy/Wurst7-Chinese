# Wurst Client v7 - 中文汉化版

基于 [Wurst-Imperium/Wurst7](https://github.com/Wurst-Imperium/Wurst7) `v7.50.3-MC1.20.1` 的**全面中文汉化**版本。

## 汉化内容

| 项目 | 数量 | 说明 |
|------|------|------|
| **功能分类名** | 8 个 | Blocks→方块, Combat→战斗, Movement→移动 等 |
| **功能名称** | 130+ 个 | KillAura→杀戮光环, Flight→飞行, Zoom→缩放 等 |
| **功能描述** | 305 条 | 通过 `zh_cn.json` 翻译文件实现 |
| **设置项名称** | 270+ 个 | Range→范围, Speed→速度, Filter players→过滤玩家 等 |
| **界面按钮/文字** | 全部 | Wurst 设置、快捷键管理、导航器、服务器搜索等所有界面 |
| **提示信息** | 全部 | 滑块/复选框/颜色选择器的工具提示 |

## 安装方法

### 方式一：直接使用编译好的 jar

1. 安装 [Fabric Loader](https://fabricmc.net/use/installer/) (Minecraft 1.20.1)
2. 下载 [Fabric API](https://modrinth.com/mod/fabric-api) 放入 `mods` 文件夹
3. 从 [Releases](https://github.com/Guli-Joy/Wurst7-Chinese/releases) 下载汉化版 jar 放入 `mods` 文件夹
4. 启动游戏

### 方式二：从源码编译

> [!IMPORTANT]
> 需要安装 [JDK 17](https://adoptium.net/?variant=openjdk17&jvmVariant=hotspot)（也兼容更高版本）。

```bash
git clone https://github.com/Guli-Joy/Wurst7-Chinese.git
cd Wurst7-Chinese
./gradlew build -x test -x spotlessCheck
```

编译完成后，jar 文件位于 `build/libs/` 目录。

## 使用说明

- 按 **右 Ctrl** 键打开 ClickGUI（点击界面）
- 按 `.` 键打开命令行（输入 `.help` 查看所有命令）
- 在 Wurst 设置 > 翻译 中关闭 **"强制英语"** 即可显示中文功能描述

## 开发设置

### Eclipse

```bash
git clone https://github.com/Guli-Joy/Wurst7-Chinese.git
cd Wurst7-Chinese
./gradlew genSources eclipse
```

在 Eclipse 中导入项目即可。

### VSCode / Cursor / Windsurf

```bash
git clone https://github.com/Guli-Joy/Wurst7-Chinese.git
cd Wurst7-Chinese
./gradlew genSources vscode
```

用编辑器打开项目文件夹。

### IntelliJ IDEA

```bash
git clone https://github.com/Guli-Joy/Wurst7-Chinese.git
cd Wurst7-Chinese
./gradlew genSources idea --no-configuration-cache
```

## 贡献

欢迎提交 Pull Request 来改进翻译或修复翻译错误。

## 致谢

- 原项目：[Wurst-Imperium/Wurst7](https://github.com/Wurst-Imperium/Wurst7) by Alexander01998
- 汉化翻译工作基于 GPLv3 许可证进行

## 许可证

本项目遵循 **GNU General Public License v3** 开源许可证。**只能在同样使用 GPLv3 许可证的开源客户端中使用此代码，不允许用于闭源/专有客户端！**
