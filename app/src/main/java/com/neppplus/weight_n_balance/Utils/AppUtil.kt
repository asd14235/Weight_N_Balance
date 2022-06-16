package com.neppplus.weight_n_balance.Utils

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView

class AppUtil {

    companion object {

        fun hideSoftInput(context: Context, editText: EditText) {
            val inputMethodManager =
                context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(editText.windowToken, 0)

        }

        fun checkEdit(editText: EditText) : Int {
            if ( editText.text.toString().isBlank()) {
                return 0
            } else {
                return editText.text.toString().toInt()
            }
        }

        fun checkText(textView: TextView) : Int {
            if (textView.text.toString().isNullOrBlank()) {
                return 0
            } else { return textView.text.toString().toInt() }
        }
    }
}