package iii_conventions

data class MyDate(val year: Int,
                  val month: Int,
                  val dayOfMonth: Int): Comparable<MyDate> {

	override fun compareTo(other: MyDate): Int {

        if(this.year != other.year) return this.year - other.year
        if(this.month != other.month) return this.month - other.month

        return this.dayOfMonth - other.dayOfMonth
	}
}

operator fun MyDate.rangeTo(other: MyDate) = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

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

		return start <= date && date <= endInclusive
	}
}
