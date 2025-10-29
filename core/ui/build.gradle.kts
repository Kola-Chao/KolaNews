plugins {
    alias(libs.plugins.nowinandroid.android.library)
    alias(libs.plugins.nowinandroid.android.library.compose)
}

android {
    namespace = "com.kola.news.core.ui"
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.navigation.compose)
}
