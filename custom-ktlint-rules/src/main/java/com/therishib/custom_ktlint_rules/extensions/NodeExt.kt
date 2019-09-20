package com.therishib.custom_ktlint_rules.extensions

import com.pinterest.ktlint.core.ast.ElementType.KDOC_TEXT
import org.jetbrains.kotlin.com.intellij.lang.ASTNode

internal fun ASTNode.isKtDoc(): Boolean = this.elementType == KDOC_TEXT