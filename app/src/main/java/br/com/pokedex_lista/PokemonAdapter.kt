package br.com.pokedex_lista

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class PokemonAdapter (val contexto: Context, val lista: ArrayList<PokemonModel>, val click: (position: Int) -> Unit):
    RecyclerView.Adapter<PokemonAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val IvPokemon = view.findViewById<ImageView>(R.id.ivPokemon)
        val TvNome = view.findViewById<TextView>(R.id.tvNome)
    }

    // Infla o layout do item do RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(contexto).inflate(R.layout.pokemon_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val pokemon = lista[position]

        // Definir a cor de fundo com base na cor do Pokémon
        val color = Color.parseColor(pokemon.cor)
        holder.itemView.setBackgroundColor(color)

        // Carregar a imagem do Pokémon
        Glide
            .with(contexto)
            .load(lista[position].foto)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
            .into(holder.IvPokemon)

        // Definir o nome do Pokémon
        holder.TvNome.text = pokemon.nome

        // Definir o clique no item do RecyclerView
        holder.itemView.setOnClickListener {
            click(position)
        }
    }

}