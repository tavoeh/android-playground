package com.tavoeh.playground.presentation.model

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding

/**
 * Created by Gustavo Enriquez on 4/7/20.
 **/

data class RecyclerItem(
    val data: Any,
    @LayoutRes val layoutId: Int,
    val variableId: Int
) {
    fun bind(binding: ViewDataBinding) {
        binding.setVariable(variableId, data)
    }
}