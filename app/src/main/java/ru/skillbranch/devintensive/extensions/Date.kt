package ru.skillbranch.devintensive.extensions

import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60 * SECOND
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY,
}


fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}

fun Date.add(value: Int, units: TimeUnits = TimeUnits.SECOND): Date{
    var time = this.time

    time += when(units){
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY

    }
    this.time = time
    return this
}

fun Date.humanizeDiff(date : Date = Date()):String {
    val timeNow = this.time

    //var timeNow = Date().add(-5,TimeUnits.DAY).time

    val time = (timeNow-date.time) / 1000
    val state = when (time) {
        in 0..1 -> "только что"
        in 1..45 -> "через несколько секунд"
        in 45..75 -> "через минуту"
        in 75..45*60 -> "через ${time/ 60} минут "
        in 45*60..75*60 -> "через час"
        in 75*60..22*60*60  -> "через ${time/60/60} часов"
        in 22*60*60..26* 60*60  ->  "через день"
        in 22*60*60..360* 60*60 -> "более чем ${kotlin.math.abs(time / 60 / 60 / 24)} днея(ей) назад"
        in 360*60*60..Long.MAX_VALUE -> "более чем ${time/ 60/60/24} днея(й) назад"
        in -1..0 -> "только что"
        in -45..-1 -> "несколько секунд назад"
        in -75..-45 -> "минуту назад"
        in -45*60..-75 -> "${kotlin.math.abs(time / 60)} минут(ы) назад"
        in -75*60..-45* 60 -> "час назад"
        in -22* 60*60..-75* 60  -> "${kotlin.math.abs(time / 60 / 60)} часа(ов) назад"
        in  -26* 60*60..-22*60*24  ->  "день назад"
        in -360* 60*60..-22* 60*60 -> "${kotlin.math.abs(time/ 60/60/24)} днея(й) назад"
        else -> "более года назад"
    }
    return state
}

