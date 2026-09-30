package com.example.minishopmanager

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNext = findViewById<Button>(R.id.btnNext)

        btnNext.setOnClickListener {
            Toast.makeText(this, "Bonjour Noor BEN YEDDER !", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        Log.d("LIFECYCLE", "onCreate appelé")

        // TP2 : catalogue de produits
        val listView = findViewById<ListView>(R.id.listViewProduits)
        val produits = resources.getStringArray(R.array.produits)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, produits)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, _, position, _ ->
            val item = parent.getItemAtPosition(position).toString()
            Toast.makeText(this, "Produit sélectionné : $item", Toast.LENGTH_SHORT).show()
        }
    }
}