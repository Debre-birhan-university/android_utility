package org.debrebirhan.dashen

interface PinInterface {
    fun savePin(pin: String)
    fun getPin(): String
    fun isPinSet(): Boolean
}