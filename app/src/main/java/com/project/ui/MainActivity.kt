package com.project.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import com.project.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun tryLogin(ui:AnkoContext<MainActivity>, name:CharSequence?,password:CharSequence?) {
        ui.doAsync {  }
    }

    class MainActivityUi : AnkoComponent<MainActivity> {

        private val customStyle = { v: Any ->
            when (v) {
                is Button -> v.textSize = 26f
                is EditText -> v.textSize = 24f
            }

        }

        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            verticalLayout{
                padding = dip(32)

                imageView(R.mipmap.ic_launcher).lparams {
                    margin = dip(16)
                    gravity = Gravity.CENTER
                }

                val name = editText {
                    hintResource = R.string.app_name
                }
                val password = editText {
                    hintResource = R.string.app_name
                }

                button("Log in") {
                    onClick {
                        ui.owner.trylo
                    }
                }
            }
        }

    }
}
