# 贡献指南

感谢你考虑为本项目做出贡献！以下是一些帮助你入门的指南。

## Pull Requests

### 1. 保持 PR 小而专注
- **一个 PR 只做一件事**：每个 PR 应只解决一个问题或添加一个功能。
- **避免臃肿**：保持 diff 简洁易读，不要在 PR 中塞入无关的改动。

### 2. 尊重项目范围
- **编码前先沟通**：在开始重大改动之前，先开一个 Issue 讨论。这样可以避免你的想法被拒绝后浪费时间。
- **避免破坏性更改**：修改现有功能时，最好让你的更改是可选的。

### 3. 确保质量和完整性
- **完成代码再提交**：只在代码完成、测试通过、准备好接受审查时才提交 PR。
- 如果需要早期反馈，请将 PR 标记为草稿。
- **关注自动检查**：确保所有自动检查通过且没有合并冲突。

### 4. 遵循代码风格
- 使用 `codestyle` 文件夹中的设置运行 Eclipse 的 Clean Up 和 Format 工具。
- 如果不使用 Eclipse，可以运行 `./gradlew spotlessApply`。
- 对于自动工具未覆盖的部分，请尽量匹配现有代码风格。

## 翻译相关贡献

本项目特别欢迎以下翻译相关的贡献：

- **修正翻译错误**：发现不准确的中文翻译，请提交修复
- **补充遗漏翻译**：发现仍有英文文字未翻译，请提交补充
- **改进翻译质量**：使翻译更加自然、准确、符合游戏术语习惯
- **添加新功能的翻译**：如果上游项目添加了新功能，需要同步翻译

### 翻译文件位置

- **功能描述翻译**：`src/main/resources/assets/wurst/translations/zh_cn.json`
- **功能名称翻译**：`src/main/java/net/wurstclient/hack/Hack.java` 中的 `CHINESE_NAMES` 映射
- **设置名称翻译**：`src/main/java/net/wurstclient/settings/Setting.java` 中的 `DISPLAY_NAMES` 映射
- **分类名称翻译**：`src/main/java/net/wurstclient/Category.java` 中的 `displayName` 字段

## 其他贡献方式

- 报告翻译错误或遗漏
- 测试不同 Minecraft 版本的兼容性
- 编写使用教程
- 分享本项目给需要中文界面的玩家
