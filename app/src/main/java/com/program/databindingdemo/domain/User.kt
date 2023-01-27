package com.program.databindingdemo.domain

data class User(val name:String,val age :Int ,val gender:Gender) {

}
enum class Gender{
    Male,Female
}