package ru_skil.dev.models

class UserView(
    val id:String,
    val fullName:String,
    val nickName:String,
    var avatar: String?,
    val status:String? = "offline",
    val initials:String?
) {
    fun printMe() {
        println("""
            id: $id
            fullName: $fullName
            nickName: $nickName
            avatar: $avatar
            status: $status
            initials: $initials
        """.trimIndent())
    }
}