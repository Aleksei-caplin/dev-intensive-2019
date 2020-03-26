package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.models.data.User
import ru.skillbranch.devintensive.models.UserView
import ru.skillbranch.devintensive.utils.Utils

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

//fun Date.humanizeDiff(date:Date = Date()):String {
//    //TODO "not implementer"
//
//    return ""
//}