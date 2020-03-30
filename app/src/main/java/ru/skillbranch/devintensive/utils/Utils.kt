package ru.skillbranch.devintensive.utils

import android.content.Context
import android.content.res.Configuration
import android.util.TypedValue
import ru.skillbranch.devintensive.R
import java.util.*

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?> {
        val list: List<String> = fullName?.split(" ")?:listOf()
        if(list.isEmpty())
            return null to null
        var firstName = list.getOrNull(0)
        var lastName = list.getOrNull(1)


        if (firstName.isNullOrBlank()) {
            firstName = null
        } else if (lastName.isNullOrBlank()) {
            lastName = null
        }
        return firstName to lastName
    }

    fun transliteration(payload:String, divider: String = " "): String {
        var state = ""
        for(i in payload.toLowerCase()) {
            state += when(i.toString().toLowerCase(Locale.getDefault())) {
                "а" -> "a"
                "б" -> "b"
                "в" -> "v"
                "г" -> "g"
                "д" -> "d"
                "е" -> "e"
                "ё" -> "e"
                "ж" -> "zh"
                "з" -> "z"
                "и" -> "i"
                "й" -> "i"
                "к" -> "k"
                "л" -> "l"
                "м" -> "m"
                "н" -> "n"
                "о" -> "o"
                "п" -> "p"
                "р" -> "r"
                "с" -> "s"
                "т" -> "t"
                "у" -> "u"
                "ф" -> "f"
                "х" -> "h"
                "ц" -> "c"
                "ч" -> "ch"
                "ш" -> "sh"
                "щ" -> "sh"
                "ъ" -> ""
                "ы" -> "i"
                "ь" -> ""
                "э" -> "e"
                "ю" -> "yu"
                "я" -> "ya"
                else -> i
            }
        }
        return state.split(" ").joinToString(separator = divider) { it.capitalize() }
    }

    fun toInitials(firstName:String?, lastName: String?): String? {
        return if (!firstName.isNullOrBlank() && !lastName.isNullOrBlank())
            firstName[0].toString().toUpperCase() + lastName[0].toString().toUpperCase()
        else if (firstName.isNullOrBlank() && !lastName.isNullOrBlank()) lastName[0].toString().toUpperCase()
        else if (!firstName.isNullOrBlank() && lastName.isNullOrBlank()) firstName[0].toString().toUpperCase()
        else null
    }

    fun getThemeAccentColor(context: Context): Int {
        val value = TypedValue()
        context.theme.resolveAttribute(R.attr.colorAccent, value, true)
        return value.data
    }

    fun getCurrntModeColor(context: Context, attrColor: Int): Int {
        val value = TypedValue()
        context.theme.resolveAttribute(attrColor, value, true)
        return value.data
    }

    fun isNightModeActive(context: Context): Boolean {
        return when (context.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) {
            Configuration.UI_MODE_NIGHT_YES -> true
            else -> false
        }
    }


}