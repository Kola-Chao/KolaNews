plugins {
    alias(libs.plugins.nowinandroid.android.feature)
    alias(libs.plugins.nowinandroid.android.library.compose)
}

android {
    namespace = "com.kola.news.feature.profile"
}

dependencies {
    implementation(libs.androidx.compose.material3)
}
