package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import ru.skillbranch.devintensive.models.data.Chat
import ru.skillbranch.devintensive.models.data.User
import java.util.*

class TextMessage(
    id:String,
    from: User?,
    chat: Chat?,
    isIncomming: Boolean = false,
    date:Date = Date(),
    var text: String?
) : BaseMessage(id, from, chat, isIncomming, date) {
    override fun formatMessage():String = "id:$id ${from?.firstName}" +
            " ${if(isIncomming) "получил" else "отправил"} сообщение \"$text\" ${date.humanizeDiff()}"
}