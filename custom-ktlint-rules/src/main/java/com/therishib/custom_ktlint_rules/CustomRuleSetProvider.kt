package com.therishib.custom_ktlint_rules

import com.pinterest.ktlint.core.RuleSet
import com.pinterest.ktlint.core.RuleSetProvider
import com.therishib.custom_ktlint_rules.rules.NoForceUnwrapRule

class CustomRuleSetProvider : RuleSetProvider {
    override fun get(): RuleSet = RuleSet(
        "custom",
        NoForceUnwrapRule()
    )

}