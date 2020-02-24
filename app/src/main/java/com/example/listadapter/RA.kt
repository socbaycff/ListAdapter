package com.example.listadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.listadapter.databinding.ItemBinding

data class User(val id: String, var content: String)

class NewAdapter: ListAdapter<User, NewAdapter.UserHolder>(MyDIff()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
           return UserHolder.from(parent) // chi goi
    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
       holder.bind(getItem(position)) // keu no bind vao item xml
    }

    class UserHolder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: User?) {
            binding.user = item // bind user vao xml
            binding.executePendingBindings() // can co
        }
        companion object {
                fun from(parent: ViewGroup): UserHolder {

                    val binding =
                        ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                    return UserHolder(binding) // lay view ra
                }
            }
    }

    class MyDIff: DiffUtil.ItemCallback<User>() {// cung cấp thông tin về cách xác định phần
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean { // cho máy biết 2 item khi nào giống
        return oldItem.id == newItem.id // dung
    }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean { // cho biết item khi nào cùng nội dung
            return oldItem == newItem
        }

    }
}

