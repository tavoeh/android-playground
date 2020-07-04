package com.tavoeh.playground.presentation.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tavoeh.playground.presentation.model.RecyclerItem

@BindingAdapter("items")
fun setRecyclerViewItems(
    recyclerView: RecyclerView,
    items: List<RecyclerItem>?
) {
    var adapter = recyclerView.adapter as? RecyclerViewAdapter
    if (adapter == null) {
        adapter = RecyclerViewAdapter()
        recyclerView.adapter = adapter
    }
    adapter.submitList(items.orEmpty())
}