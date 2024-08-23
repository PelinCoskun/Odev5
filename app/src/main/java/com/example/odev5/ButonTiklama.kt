package com.example.odev5

import androidx.compose.runtime.MutableState


fun ButonTiklama(
    metin: String,
    ekranYazisiDurum: MutableState<String>,
    gecerliGirdiDurum: MutableState<String>,
    sonucDurum: MutableState<String?>,
    sonrakiGirdiSifirla: MutableState<Boolean>
) {
    when (metin) {
        "C" -> {
            ekranYazisiDurum.value = ""
            gecerliGirdiDurum.value = ""
            sonucDurum.value = null
            sonrakiGirdiSifirla.value = false
        }
        "+" -> {
            if (gecerliGirdiDurum.value.isNotEmpty() || sonucDurum.value != null) {
                if (sonucDurum.value != null) {
                    ekranYazisiDurum.value = sonucDurum.value + "+"
                    sonucDurum.value = null
                } else {
                    ekranYazisiDurum.value += gecerliGirdiDurum.value + "+"
                }
                gecerliGirdiDurum.value = ""
            }
            sonrakiGirdiSifirla.value = false
        }
        "=" -> {
            if (gecerliGirdiDurum.value.isNotEmpty()) {
                val sonIfade = ekranYazisiDurum.value + gecerliGirdiDurum.value
                try {
                    val hesapSonucu = hesapla(sonIfade)
                    sonucDurum.value = hesapSonucu.toString()
                    ekranYazisiDurum.value = ""
                    gecerliGirdiDurum.value = ""
                    sonrakiGirdiSifirla.value = true
                } catch (e: Exception) {
                    sonucDurum.value = "Hata"
                }
            }
        }
        else -> {
            if (sonrakiGirdiSifirla.value) {
                ekranYazisiDurum.value = ""
                sonucDurum.value = null
                sonrakiGirdiSifirla.value = false
            }
            gecerliGirdiDurum.value += metin
        }
    }
}
fun hesapla(ifade: String): Int {
    return ifade.split("+").sumOf { it.toInt() }
}
