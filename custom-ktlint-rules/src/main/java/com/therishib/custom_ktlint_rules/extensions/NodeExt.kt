package com.therishib.custom_ktlint_rules.extensions

import com.pinterest.ktlint.core.ast.ElementType
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.lexer.KtTokens

internal fun ASTNode.isKtDoc(): Boolean = this.elementType == ElementType.KDOC_TEXT

internal fun ASTNode.isComment(): Boolean = KtTokens.COMMENTS.contains(this.elementType)