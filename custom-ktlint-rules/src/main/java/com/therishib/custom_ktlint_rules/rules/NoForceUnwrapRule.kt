package com.therishib.custom_ktlint_rules.rules

import com.pinterest.ktlint.core.Rule
import com.pinterest.ktlint.core.ast.isPartOfString
import com.therishib.custom_ktlint_rules.extensions.isComment
import com.therishib.custom_ktlint_rules.extensions.isKtDoc
import org.jetbrains.kotlin.com.intellij.lang.ASTNode
import org.jetbrains.kotlin.com.intellij.psi.impl.source.tree.LeafPsiElement
import org.jetbrains.kotlin.lexer.KtTokens

internal const val NO_FORCE_UNWRAP_RULE_NAME = "no-force-unwraps"

/**
 * This will check if user has any force-unwraps (otherwise known as "bang-bang" operators) in code.
 */
class NoForceUnwrapRule : Rule(NO_FORCE_UNWRAP_RULE_NAME) {
    override fun visit(
        node: ASTNode,
        autoCorrect: Boolean,
        emit: (offset: Int, errorMessage: String, canBeAutoCorrected: Boolean) -> Unit
    ) {
        if (node is LeafPsiElement &&
            !node.isKtDoc() &&
            !node.isPartOfString() &&
            !node.isComment() &&
            node.textMatches(KtTokens.EXCLEXCL.value) // node == "!!"
        ) {
            emit(
                node.startOffset,
                "No Force Unwrapping (${KtTokens.EXCLEXCL.value}) allowed. " +
                        "Please handle null case " +
                        "EG: With Elvis Operator (${KtTokens.ELVIS.value})",
                false
            )
        }
    }
}