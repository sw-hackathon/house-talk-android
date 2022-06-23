package com.likefirst.meyouhouse.util

import com.likefirst.meyouhouse.util.ApplicationClass.Companion.mSharedPreferences

// example
//fun saveJwt(jwtToken: String) {
//    val editor = mSharedPreferences.edit()
//    editor.putString("jwt", jwtToken)
//    editor.apply()
//}
//
//fun getJwt(): String? = mSharedPreferences.getString("jwt", null)
//
//fun removeJwt(){
//    val editor = mSharedPreferences.edit()
//    editor.remove("jwt")
//    editor.commit()
//}

fun saveClient(){
    val editor = mSharedPreferences.edit()
    editor.putString("Authorization_client", "client")
    editor.apply()
}

fun getClient() : String? = mSharedPreferences.getString("Authorization_client", "client")

fun removeClient(){
    val editor = mSharedPreferences.edit()
    editor.remove("Authorization_client")
    editor.commit()
}

fun saveHost(){
    val editor = mSharedPreferences.edit()
    editor.putString("Authorization_host", "host")
    editor.apply()
}

fun getHost() : String? = mSharedPreferences.getString("Authorization_host", "host")

fun removeHost(){
    val editor = mSharedPreferences.edit()
    editor.remove("Authorization_host")
    editor.commit()
}