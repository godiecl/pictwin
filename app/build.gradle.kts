/*
 * Copyright (c) 2024. Departamento de Ingenieria de Sistemas y Computacion.
 */

import org.gradle.kotlin.dsl.libs

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false

    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.ksp) apply false
}


