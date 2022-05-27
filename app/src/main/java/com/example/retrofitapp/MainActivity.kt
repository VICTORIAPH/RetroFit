package com.example.retrofitapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.example.retrofitapp.remote.PokemonEntry
import com.example.retrofitapp.remote.RetroFitBuilder
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //image
        val image = findViewById<ImageView>(R.id.ivPhoto)
        Picasso.get().load("https://i.imgur.com/DvpvklR.png").into(image)

    //para consumir una appi, se necesita
        //1.- agregar las implementaciones en Gradle
        //2.- darle permiso en ManiFest
        //3.- crear Data Class en remote

        val retrofit = RetroFitBuilder.create().getPokemonById("27")

        retrofit.enqueue(object: Callback<PokemonEntry>{
            override fun onResponse(call: Call<PokemonEntry>, response: Response<PokemonEntry>) {
                Log.d("response", "res: ${response.body()}")
                Log.d("response", "name: ${response.body()?.name}")
                Log.d("retrofitresponse", "front_default: ${response.body()?.sprites?.front_default}")
             //   Log.d("response", "sprites: ${response.body()?.sprites}")
                val stats = response.body()?.stats
                if (stats != null){
                    for(stat in stats){
                        Log.d("response", "stats: ${stat.stat.stat_value} ${stat.base_stats}")
                    }
                }
              /*
                    }
                }*/
                val typesArray = response.body()?.types
                 if (typesArray != null){
                    for(type in typesArray){
                        Log.d("response", "typesArray: ${type.type.name} ")
                    }
                }
            }

            override fun onFailure(call: Call<PokemonEntry>, t: Throwable) {
                Log.e("response", "error: ${t.message}")
            }
        })

    }
}