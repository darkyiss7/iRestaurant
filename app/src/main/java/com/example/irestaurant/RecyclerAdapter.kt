package com.example.irestaurant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.squareup.picasso.Picasso

class RecyclerAdapter(private val platListe: java.util.ArrayList<Item>, val clickListener: (Item) -> Unit) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView : TextView = itemView.findViewById(R.id.text)
        val image : ImageView = itemView.findViewById(R.id.imagePreview)
        val prix : TextView = itemView.findViewById(R.id.description)
       // val ingredients : TextView = itemView.findViewById(R.id.ingredientsView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)
        return ViewHolder(View)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = platListe[position]
        holder.textView.text = item.name_fr
        holder.prix.text = "Prix : "+item.prices[0].price + "€"
      //  holder.ingredients.text = item.ingredients[0].name_fr
        Picasso.get().load(item.images[0].ifEmpty { null })
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.image)
        holder.itemView.setOnClickListener{
            clickListener(item)
        }
    }

    override fun getItemCount(): Int {
        return platListe.size
    }
}