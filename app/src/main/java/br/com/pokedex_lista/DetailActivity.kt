package br.com.pokedex_lista

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nome = intent.getStringExtra("nome")
        val foto = intent.getStringExtra("imagem")
        val corFundo = intent.getStringExtra("corFundo")
        val color = Color.parseColor(corFundo)
        val info1 = intent.getStringExtra("especie1")
        val info2 = intent.getStringExtra("especie2")
        val altura = intent.getIntExtra("altura", 0)
        val peso = intent.getIntExtra("peso", 0)

        findViewById<TextView>(R.id.TvNomePerfil).text = nome
        findViewById<TextView>(R.id.tvAltura).text = altura.toString() + " cm"
        findViewById<TextView>(R.id.TvPeso).text = peso.toString() + " kg"
        findViewById<Button>(R.id.BtEspecie).text = info1
        // Verifica se há uma informação 2 e a torna visível se existir
        if (!info2.isNullOrBlank()) {
            findViewById<Button>(R.id.BtEspecie2).visibility = View.VISIBLE
            findViewById<Button>(R.id.BtEspecie2).text = info2
        }

        val viewBackground = findViewById<View>(R.id.view) // Obtém a referência à view de fundo
        window.decorView.setBackgroundColor(color) // Define a cor de fundo da janela da atividade
        viewBackground.setBackgroundColor(color) // Define a cor de fundo da view de fundo

        val imageView = findViewById<ImageView>(R.id.IvPokemonPerfil) // Obtém a referência ao ImageView

        // Carrega a imagem do Pokémon usando a biblioteca Glide
        Glide
            .with(this)
            .load(foto)
            .apply(RequestOptions.bitmapTransform(RoundedCorners(100)))
            .into(imageView)

        findViewById<Button>(R.id.BtnVoltar).setOnClickListener {
            finish()
        }
    }
}