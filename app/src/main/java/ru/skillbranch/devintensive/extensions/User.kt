package ru_skil.dev.extensions

import ru_skil.dev.models.User
import ru_skil.dev.models.UserView
import ru_skil.dev.utils.Utils
import java.util.*

fun User.toUserView():UserView{

    val nickNAme = Utils.transliteration("$firstName $lastName")
    val initials = Utils.toInitials(firstName, lastName)
    val status = if(lastVisit == null) "Еще ни разу не был" else if (isOnline) "online" else "Последний раз был ${lastVisit.humanizeDiff()}"

    return UserView(id,
                    fullName = "$firstName $lastName",
                    nickName = nickNAme,
                    initials = initials,
                    avatar = "$avatar",
                    status = status
    )
}

fun Date.humanizeDiff(date:Date = Date()):String {
    //TODO "not implementer"

    return ""
}