package iii_conventions

data class MyDate(val year: Int,
                  val month: Int,
                  val dayOfMonth: Int): Comparable<MyDate> {

	override fun compareTo(other: MyDate) = when {

        this.year != other.year -> this.year - other.year
        this.month != other.month -> this.month - other.month
		else -> this.dayOfMonth - other.dayOfMonth
	}

	operator fun plus(timeInterval: TimeInterval) = this.addTimeIntervals(timeInterval, 1)

	operator fun plus(timeIntervalExtra: TimeIntervalExtra) = this.addTimeIntervals(timeIntervalExtra.timeInterval, timeIntervalExtra.times)
}

operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR;

	operator fun times(multiplier: Int) = TimeIntervalExtra(this, multiplier)
}

class TimeIntervalExtra(val timeInterval: TimeInterval,
						val times: Int)

class DateRange(private val start: MyDate,
				private val endInclusive: MyDate): Iterable<MyDate>{

	override fun iterator(): Iterator<MyDate> {

		val list: ArrayList<MyDate> = arrayListOf()

		var next = start
		while(next <= endInclusive){

			list.add(next)
			next = next.nextDay()
		}

		return list.iterator()
	}

	operator fun contains(date: MyDate): Boolean{

		return date in start..endInclusive
	}
}
