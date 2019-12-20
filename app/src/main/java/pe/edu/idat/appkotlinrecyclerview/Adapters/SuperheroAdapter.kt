package pe.edu.idat.appkotlinrecyclerview.Adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.squareup.picasso.Picasso
import pe.edu.idat.appkotlinrecyclerview.Modelos.Superhero
import pe.edu.idat.appkotlinrecyclerview.R

class SuperheroAdapter
    : RecyclerView.Adapter<SuperheroAdapter.ViewHolder>() {

    var superheros: MutableList<Superhero>  = ArrayList()
    lateinit var context: Context


    fun SuperheroAdapter(superheroes : MutableList<Superhero>, context: Context){
        this.superheros = superheroes
        this.context = context
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_list, p0, false))
    }

    override fun getItemCount(): Int {
        return superheros.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val item = superheros.get(p1)
        p0.bind(item, context)

    }


    class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
        val superheroName = view.findViewById(R.id.tvSuperhero) as TextView
        val realName = view.findViewById(R.id.tvRealName) as TextView
        val publisher = view.findViewById(R.id.tvPublisher) as TextView
        val avatar = view.findViewById(R.id.ivAvatar) as ImageView

        fun bind(superhero:Superhero, context: Context){
            superheroName.text = superhero.superhero
            realName.text = superhero.realName
            publisher.text = superhero.publisher
            itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, superhero.superhero, Toast.LENGTH_SHORT).show() })
            avatar.loadUrl(superhero.photo)
        }

        fun ImageView.loadUrl(url: String) {
            Picasso.with(context).load(url).into(this)
        }
    }
}