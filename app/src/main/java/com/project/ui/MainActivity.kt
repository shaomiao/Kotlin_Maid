package com.project.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import com.project.R
import kotlinx.android.synthetic.main.activity_main2.*
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        verticalLayout {
////            padding = dip(30)
//            editText {
//                hint = "Name"
//                textSize = 24f
//
//            }
//            editText {
//                hint = "Password"
//                textSize = 24f
//            }
//            button("Login") {
//                textSize = 26f
//            }
//        }
//
//
//        linearLayout {
//            button("Login") {
//                textSize = 26f
//            }.lparams(width = wrapContent) {
//                horizontalMargin = dip(5)
//                topMargin = dip(10)
//            }
//        }
//        MainActivityUi().setContentView(this)
        setContentView(R.layout.activity_main2)
        message.text = "Hello Kotlin!"
    }

    fun tryLogin(ui: AnkoContext<MainActivity>, name: CharSequence?, password: CharSequence?) {
        ui.doAsync {
            Thread.sleep(500)

            activityUiThreadWithContext {
                //                if (checkcreden)
                if (checkCredentials(name.toString(),password.toString())) {
                    toast("Logged in !:)")
                } else {
                    toast("Wrong password :( Enter user:password")
                }
            }
        }
    }

    private fun checkCredentials(name: String, password: String) = name == "user" && password == "password"

}

class MainActivityUi : AnkoComponent<MainActivity> {


    private val customStyle = { v: Any ->
        when (v) {
            is Button -> v.textSize = 26f
            is EditText -> v.textSize = 24f
        }

    }

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        verticalLayout {

            val name1 = editText()
            button("Say Hello") {
                onClick {
                    alert ("Hi,Im Roy","Have you tried turning it off and on again?"){
                        yesButton {
                            toast("hello, ${name1.text}!")
                        }
                        noButton {
                        }
                    }.show()
                }
            }
            button("shaomiao"){
                onClick {
                    alert{
                        customView {
                            editText()
                        }
                        yesButton {  }
                        noButton {  }
                    }.show()
                }
            }
            button("shaomiao2") {
                onClick {
                    progressDialog (message = "Please wait a bit..",title = "Fetching data").show()
                }
            }
            button("shaomiao3") {
                onClick {
                    val countries = listOf("Russia","USA","Japan","Australia")
                    selector("Where are you from?",countries,{
                        dialogInterface, i ->
                        toast("So you're living in ${countries[i]},right?")
                    })
                }
            }
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
                    ui.owner.tryLogin(ui,name.text,password.text)
                }
            }

        }.applyRecursively(customStyle)
    }


}

