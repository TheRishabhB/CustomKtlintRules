package com.therishib.customktlintrules

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class TestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val kk: Int? = null
        val y: Int = kk!! // ktlint-disable custom:no-force-unwraps

        /* ktlint-disable custom:no-force-unwraps */
        val lol: Int? = null
        val y: Int = lol!!
        /* ktlint-enable custom:no-force-unwraps */

        val x: Int? = null
        val y: Int? = null

        x.let {
            y.let {
                // BLAH
            }
        }

        x.let { xAxis ->
            y.let { yAxis ->
                // Intentionally left empty
            }
        }

        val view: View? = null

        view?.apply {
            visibility = View.INVISIBLE
            contentDescription = "BLAH"
            setOnClickListener { /* Left Empty! */ }
        }
    }
}
