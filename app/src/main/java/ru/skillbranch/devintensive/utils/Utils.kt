package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
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
        //TODO ("not implement")

        return "123"
    }

    fun toInitials(firstName:String?, lastName: String?): String? {
        return if (!firstName.isNullOrBlank() && !lastName.isNullOrBlank())
            firstName[0].toString().toUpperCase() + lastName[0].toString().toUpperCase()
        else if (firstName.isNullOrBlank() && !lastName.isNullOrBlank()) lastName[0].toString().toUpperCase()
        else if (!firstName.isNullOrBlank() && lastName.isNullOrBlank()) firstName[0].toString().toUpperCase()
        else null
    }
}