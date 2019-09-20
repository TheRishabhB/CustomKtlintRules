package com.therishib.custom_ktlint_rules.rules

import com.pinterest.ktlint.core.Rule
import com.pinterest.ktlint.core.ast.isPartOfString
import com.therishib.custom_ktlint_rules.extensions.isKtDoc
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.com.intellij.psi.impl.source.tree.LeafPsiElement

const val FORCE_UNWRAP_RULE_NAME = "no-force-unwraps"

private const val FORCE_UNWRAP_TEXT: String = "!!"

class NoForceUnwrapRule : Rule(FORCE_UNWRAP_RULE_NAME) {
    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (node is LeafPsiElement &&
            !node.isKtDoc() &&
            !node.isPartOfString() &&
            !node.isPartOfString() &&
            node.textMatches(FORCE_UNWRAP_TEXT)
        ) {
            emit(node.startOffset, "Force unwrapping at \"${node.text}\"", false)
        }
    }
}