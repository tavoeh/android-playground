package com.tavoeh.playground.presentation.intro

import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tavoeh.playground.R
import com.tavoeh.playground.presentation.model.Header
import com.tavoeh.playground.presentation.model.RecyclerItem
import com.tavoeh.playground.presentation.model.User

/**
 * Created by Gustavo Enriquez on 5/7/20.
 **/

class IntroViewModel : ViewModel() {

    val data = MutableLiveData<List<RecyclerItem>>()

    init {
        loadData()
    }

    private fun loadData() {
        data.value = listOf(Header().toRecyclerItem()) + users.map { it.toRecyclerItem() }
    }

    private val users
        get() = listOf(
            User(1, "Gustavo Enriquez", "tavoeh@gmail.com"),
            User(2, "Aimee Gonzalez", "aimee@gmail.com")
        )

    private fun Header.toRecyclerItem() = RecyclerItem(
        data = this,
        variableId = BR.header,
        layoutId = R.layout.item_header
    )

    private fun User.toRecyclerItem() = RecyclerItem(
        data = this,
        variableId = BR.user,
        layoutId = R.layout.item_user
    )

}