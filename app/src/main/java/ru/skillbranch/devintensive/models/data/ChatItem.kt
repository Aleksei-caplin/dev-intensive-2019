package ru.skillbranch.devintensive.models.data

data class ChatItem(
    val id: String,
    val avatar: String?,
    val initials: String,
    val title : String,
    val shotDescription: String?,
    val messageCount: Int = 0,
    val lastMessageData: String?,
    val isOnline: Boolean = false,
    val chatType: ChatType = ChatType.SINGLE,
    val author: String? = null
) {
}