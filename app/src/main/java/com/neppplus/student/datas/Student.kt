package com.neppplus.student.datas

import java.util.*

class Student(
    val name: String,
    val birthYear: Int,
    val address: String)  {

    fun getKoreanAge() : Int {
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)

        val koreanAge = currentYear - this.birthYear + 1

        return koreanAge
    }


    fun addTwoNumbers(num1 : Int, num2 : Int) : Int {

        val result = num1 + num2

        return result
    }

}