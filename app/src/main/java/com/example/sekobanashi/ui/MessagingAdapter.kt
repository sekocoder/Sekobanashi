package com.example.sekobanashi.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sekobanashi.R
import com.example.sekobanashi.data.Message
import com.example.sekobanashi.utils.Constants.RECEIVE_ID
import com.example.sekobanashi.utils.Constants.SEND_ID
import kotlinx.android.synthetic.main.msg_item.view.*

class MessagingAdapter:RecyclerView.Adapter<MessagingAdapter.MessageViewHolder>() {

    var messagesList = mutableListOf<Message>()

    inner class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
       init{
           itemView.setOnClickListener {
               messagesList.removeAt(adapterPosition)
               notifyItemRemoved(adapterPosition)
           }
       }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        return MessageViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.msg_item,parent,false))
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val currentMessage = messagesList[position]

        when(currentMessage.id){
            SEND_ID -> {
                holder.itemView.tv_message.apply {
                  text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_bot_message.visibility = View.GONE
            }

            RECEIVE_ID -> {
                holder.itemView.tv_bot_message.apply {
                    text = currentMessage.message
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_message.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return messagesList.size
    }

    fun insertMessage(message: Message){
        this.messagesList.add(message)
        notifyItemInserted(messagesList.size)
        //notifyDataSetChanged()
    }
}