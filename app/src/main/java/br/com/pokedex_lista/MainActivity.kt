package br.com.pokedex_lista

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    /*
     * GABRIELLA DO BOM CONSELHO BARBOSA
     * MATRÍCULA: 72100745
     * PROFESSOR: LUCAS NICODEMOS RODRIGUES DA SILVA
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pokemonList = ArrayList<PokemonModel>() // Sua lista de dados de Pokémon

        pokemonList.add(PokemonModel("Squirtle", "#4592c4", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/007.png", "Água", "", 50, 9))
        pokemonList.add(PokemonModel("Pikachu", "#eed535", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/025.png", "Elétrico", "", 40, 6))
        pokemonList.add(PokemonModel("Charmander", "#fd7d24", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/004.png", "Fogo", "", 60, 8))
        pokemonList.add(PokemonModel("Bulbasaur", "#9bcc50", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/001.png", "Grama", "Tóxico", 70, 7))
        pokemonList.add(PokemonModel("Darkrai", "#707070", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/491.png", "Escuridão", "", 150, 50))
        pokemonList.add(PokemonModel("Charizard", "#fd7d24", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/006.png", "Fogo", "Vôo", 170, 90))
        pokemonList.add(PokemonModel("Blastoise", "#4592c4", "https://assets.pokemon.com/assets/cms2/img/pokedex/full/009.png", "Água", "", 160, 85))

        // Inicializar e configurar o RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.rvPokemons)
        val layoutManager = LinearLayoutManager(this)
        val adapter = PokemonAdapter(this, pokemonList) { position ->
            // Tratar o clique em um item do RecyclerView
            val selectedPokemon = pokemonList[position]

            // Criar um Intent para abrir a DetailActivity
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("corFundo", selectedPokemon.cor)
            intent.putExtra("nome", selectedPokemon.nome)
            intent.putExtra("imagem", selectedPokemon.foto)
            intent.putExtra("especie1", selectedPokemon.info1)
            intent.putExtra("especie2", selectedPokemon.info2)
            intent.putExtra("altura", selectedPokemon.altura)
            intent.putExtra("peso", selectedPokemon.peso)

            // Iniciar a DetailActivity
            startActivity(intent)
        }

        // Configurar o RecyclerView com o adaptador e o gerenciador de layout
        recyclerView.adapter = adapter
        recyclerView.layoutManager = layoutManager

    }
}