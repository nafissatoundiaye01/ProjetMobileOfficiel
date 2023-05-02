package com.example.bilan.models
class UserSession(){
    lateinit var userSession:User

    fun setSession(user:User){
        userSession=user
    }
    fun getSession():User{
        return userSession
    }
}
