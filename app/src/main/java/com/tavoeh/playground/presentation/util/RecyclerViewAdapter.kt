package com.tavoeh.playground.presentation.util

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tavoeh.playground.presentation.model.RecyclerItem

/**
 * Created by Gustavo Enriquez on 4/7/20.
 **/

class RecyclerViewAdapter : ListAdapter<RecyclerItem, BindingViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ViewDataBinding = DataBindingUtil.inflate(inflater, viewType, parent, false)
        return BindingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingViewHolder, position: Int) {
        getItem(position).bind(holder.binding)
        holder.binding.executePendingBindings()
    }

    override fun getItemViewType(position: Int) = getItem(position).layoutId
}

class BindingViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

private class DiffCallback : DiffUtil.ItemCallback<RecyclerItem>() {
    override fun areItemsTheSame(oldItem: RecyclerItem, newItem: RecyclerItem): Boolean {
        return oldItem.data == newItem.data
    }

    override fun areContentsTheSame(oldItem: RecyclerItem, newItem: RecyclerItem): Boolean {
        return newItem.data == oldItem.data
    }

}