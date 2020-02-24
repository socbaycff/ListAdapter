package com.example.listadapter
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("noiDung")
fun bindingContent(textView: TextView, user: User?) {
    user?.let {
        textView.setText(it.content)
    }

}

@BindingAdapter("id2")
fun bindingid(textView: TextView, user: User?) {
    user?.let {
        textView.setText(it.id)
    }

}