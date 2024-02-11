/*
 * Copyright (C) 2020 Brian Norman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:OptIn(ExperimentalCompilerApi::class)

package com.bnorm.template

import com.google.auto.service.AutoService
import org.jetbrains.kotlin.backend.common.extensions.IrGenerationExtension
import org.jetbrains.kotlin.cli.common.CLIConfigurationKeys
import org.jetbrains.kotlin.cli.common.messages.MessageCollector
import org.jetbrains.kotlin.compiler.plugin.CompilerPluginRegistrar
import org.jetbrains.kotlin.compiler.plugin.ExperimentalCompilerApi
import org.jetbrains.kotlin.config.CompilerConfiguration

@AutoService(CompilerPluginRegistrar::class)
class TemplateCompilerRegistrar(
  private val defaultString: String,
  private val defaultFile: String,
) : CompilerPluginRegistrar() {
  override val supportsK2 = true

  @Suppress("unused") // Used by service loader
  constructor() : this(
    defaultString = "Hello, World!",
    defaultFile = "file.txt"
  )

  override fun ExtensionStorage.registerExtensions(configuration: CompilerConfiguration) {
    val messageCollector = configuration.get(CLIConfigurationKeys.MESSAGE_COLLECTOR_KEY, MessageCollector.NONE)
    val string = configuration.get(TemplateCommandLineProcessor.ARG_STRING, defaultString)
    val file = configuration.get(TemplateCommandLineProcessor.ARG_FILE, defaultFile)

    IrGenerationExtension.registerExtension(TemplateIrGenerationExtension(messageCollector, string, file))
  }
}
