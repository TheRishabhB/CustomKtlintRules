package com.therishib.custom_ktlint_rules

import com.pinterest.ktlint.core.LintError
import com.pinterest.ktlint.test.lint
import com.therishib.custom_ktlint_rules.rules.NO_FORCE_UNWRAP_RULE_NAME
import com.therishib.custom_ktlint_rules.rules.NoForceUnwrapRule
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class NoForceUnwrapTest {
    @Test fun `Force Unwrapping Code Will Fail KtLint`() {
        val rule = NoForceUnwrapRule()
        val failingText: String = """
            val x: Int? = null
            val y: Int = x!!
        """.trimMargin()

        val error = LintError(
            line = 2,
            col = 27,
            ruleId = NO_FORCE_UNWRAP_RULE_NAME,
            detail = "No Force Unwrapping (!!) allowed. Please handle null case EG: With Elvis Operator (?:)"
        )

        assertThat(rule.lint(failingText)).containsExactly(error)
    }

    @Test fun `Bang-Bang Operator in Comments Or Documentation Will Not Fail Rule`() {
        val rule = NoForceUnwrapRule()
        val testingString: String = """
            // This will not fail!!
            // This will not fail !!
            
            /* This will not fail!! */
            /* This will not fail !! */
            
            /*
             * Should not fail here!!
             * Or here !!
             */
             
             // ! !! !!! !!!!
             
             /**
              * Will not fail here!!
              * Or here !!
              */
        """.trimMargin()

        val error = emptyList<LintError>()

        assertThat(rule.lint(testingString)).isEqualTo(error)
    }
}