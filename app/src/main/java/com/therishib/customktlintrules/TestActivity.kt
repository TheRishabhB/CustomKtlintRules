package com.therishib.customktlintrules

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        // Should not fail here!!
        // Should not fail here !!

        /**
         * Should not fail here!!
         */

        /**
         * Should not fail here !!
         */
        val noFailure1 = "Should not fail here!!"
        val noFailure2 = "Should not fail here !!"

        // Should fail here
        val y: Bundle = savedInstanceState!!
    }
}
