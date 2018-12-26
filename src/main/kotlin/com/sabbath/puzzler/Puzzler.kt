package com.sabbath.puzzler

import com.google.gson.Gson
import org.hamcrest.MatcherAssert.assertThat

fun main(args: Array<String>) {
    val json = """[{"username":"sabbath"},]"""
    val users = mutableListOf<User>()
    val gson = Gson()
    users.addAll(gson.fromJson(json, Array<User>::class.java))
    assertThat("second element of list is null", users[1] == null)
    assertThat("list size==2", users.size == 2)
    val users2=users.filterNotNull()
    assertThat("list size==1", users2.size == 1)
}

class User(val username: String? = null)