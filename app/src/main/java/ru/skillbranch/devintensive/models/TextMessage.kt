package ru_skil.dev.models

import ru_skil.dev.extensions.humanizeDiff
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