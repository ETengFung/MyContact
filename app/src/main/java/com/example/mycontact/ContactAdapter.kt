package com.example.mycontact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mycontact.entity.Contact

class ContactAdapter:RecyclerView.Adapter<ContactAdapter.ViewHolder>()
{
    //cache copy of dataset
    private var dataSet = emptyList<Contact>()

    class ViewHolder(view: View):RecyclerView.ViewHolder(view) {
        //view (parameter) refers to layout hosting each record
        val textName:TextView = view.findViewById(R.id.textViewName)
        val textPhone:TextView = view.findViewById(R.id.textViewPhone)

        init {
            view.setOnClickListener{
                //TODO: Handle click event
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_layout,parent,false)
        return ViewHolder(view)
    }

    internal fun setContact (contact: List<Contact>){
        dataSet = contact
        notifyDataSetChanged() //refresh the RecyclerView
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Insert data from a record to the layout (ViewHolder)
        val contact = dataSet[position]
        holder.textName.text = contact.name
        holder.textPhone.text = contact.phone
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}