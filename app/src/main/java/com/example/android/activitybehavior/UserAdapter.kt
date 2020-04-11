package com.example.android.activitybehavior

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.user_item.view.*

class UserAdapter : RecyclerView.Adapter<UserAdapter.UserHolder>(){

    private var users: List<User> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder{
        return UserHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.user_item,parent,false)
        )
    }

    override fun onBindViewHolder(viewHolder: UserHolder, position: Int) {
        viewHolder.bind(users[position])
    }

    override fun getItemCount() = users.size

    fun refreshUsers(users: List<User>){
        this.users = users
        notifyDataSetChanged()
    }

    class UserHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(user: User) = with(itemView){
            userName.text = user.name
            userDescription.text = user.description
        }
    }
}