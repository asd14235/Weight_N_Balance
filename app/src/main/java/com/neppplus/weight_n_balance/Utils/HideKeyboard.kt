package com.neppplus.weight_n_balance.Utils

import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

class HideKeyboard {

    companion object {

        fun hideSoftInput(context: Context, editText: EditText) {
            val inputMethodManager =
                context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(editText.windowToken, 0)

        }
    }
}