package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
        //TODO FIX ME!!!
        val parts:  List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        var fn: String = "null"
        var ln: String = "null"

        if(firstName !== null && firstName.isNotEmpty()){
            fn = "$firstName"
        }

        if(lastName !== null && lastName.isNotEmpty()){
             ln = "$lastName"
        }

        return fn to ln
    }

    fun transliteration(payload:String, divider: String = " "): String {
        //TODO ("not implement")

        return "123"
    }

    fun toInitials(firstName:String?, lastName: String?): String? {
        //TODO ("not implement")

        var initial1: String = ""
        var initial2: String = ""

        if(firstName !== null && firstName.isNotEmpty()){
            initial1 = firstName[0].toString().toUpperCase()
        }
        if(lastName !== null && lastName.isNotEmpty()){
            initial2 = lastName[0].toString().toUpperCase()
        }

        if(firstName.isNullOrBlank() && lastName.isNullOrBlank()) {
            initial1 = "null"
        }

        if(initial2.isEmpty() && initial1.isEmpty()) {
            initial1 = "null"
        }

        return "$initial1$initial2"
    }
}