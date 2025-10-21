package com.kola.news.utils

import android.content.res.Configuration
import androidx.activity.ComponentActivity
import androidx.core.util.Consumer
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.distinctUntilChanged

/**
 * Configuration的扩展属性：判断系统是否处于深色模式
 */
val Configuration.isSystemInDarkTheme
    get() = (uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES

/**
 * ComponentActivity的扩展函数：
 * 返回一个Flow<Boolean>用于监听系统深色模式状态。
 * 订阅后立即发送当前状态，然后注册配置变化监听；关闭时移除监听。
 * 使用distinctUntilChanged避免重复发送相同值；conflate保证仅处理最新值。
 */
fun ComponentActivity.isSystemInDarkTheme() = callbackFlow {
    // 初次订阅立即发送当前配置对应的深色模式状态
    channel.trySend(resources.configuration.isSystemInDarkTheme)

    // 创建配置变化监听器，每次变化发送最新深色模式状态
    val listener = Consumer<Configuration> {
        channel.trySend(it.isSystemInDarkTheme)
    }

    // 注册监听
    addOnConfigurationChangedListener(listener)

    // Flow关闭时移除监听，防止内存泄漏
    awaitClose { removeOnConfigurationChangedListener(listener) }
}
    .distinctUntilChanged() // 过滤掉连续相同的状态
    .conflate()  // 快速变化时只保留最新值

