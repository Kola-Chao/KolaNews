# KolaNews

KolaNews 是一个使用 Kotlin 构建的模块化 Android 新闻应用示例工程，目标演示现代 Android 架构、可测试性与可配置主题。

## 项目特性
\- 基于 Gradle Kotlin DSL 与 Typesafe Project Accessors  
\- JDK 17 要求（启动时进行版本校验）  
\- 模块化结构（业务与测试分离）  
\- 可定制深色 / 跟随系统 / 关闭动态取色的主题策略  
\- 单元测试与（可扩展）UI 测试支持

## 模块结构
\- `:app` 应用入口与 UI 层  
\- `:core:testing` 测试辅助与公共测试工具

## 技术栈
\- Kotlin / Java 17  
\- AndroidX 生态  
\- Gradle (Kotlin DSL)  
\- JUnit /（可扩展为）Robolectric / Instrumentation

## 开发环境要求
\- Android Studio Narwhal 4 Feature Drop 2025.1.4  
\- JDK 17+  
\- Android SDK 最新稳定版  
\- Gradle Wrapper（无需本地安装 Gradle）

## 快速开始
```bash
# 克隆
git clone https://github.com/Kola-Chao/KolaNews.git
cd KolaNews

# 构建（验证依赖与编译）
./gradlew assembleDebug

# 运行单元测试
./gradlew test

# 运行连接设备/模拟器上的仪器测试（如后续添加）
./gradlew connectedAndroidTest
