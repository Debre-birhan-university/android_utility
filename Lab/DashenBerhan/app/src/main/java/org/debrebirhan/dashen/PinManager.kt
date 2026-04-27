package org.debrebirhan.dashen

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

interface PinInterface {
    fun savePin(pin: String)
    fun getPin(): String
    fun isPinSet(): Boolean
}

class PinManager(context: Context) : PinInterface {
    private val prefs: SharedPreferences = context.getSharedPreferences("pin_prefs", Context.MODE_PRIVATE)

    override fun savePin(pin: String) {
        // Uses the .edit { } extension for concise writing
        prefs.edit { putString("user_pin", pin) }
    }

    override fun getPin(): String {
        return prefs.getString("user_pin", "") ?: ""
    }

    override fun isPinSet(): Boolean {
        return getPin().isNotEmpty()
    }
}