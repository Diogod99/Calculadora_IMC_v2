package com.example.primeiroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

const val key_result_imc = "ResultActivity.KEY_IMC"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(key_result_imc, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassificacao = findViewById<TextView>(R.id.tv_classificacao)
        tvResult.text = result.toString()

        val classificacao = if (result <=18.5f){
            tvClassificacao.setTextColor(getColor(R.color.baixo_peso))
            "BAIXO PESO"
        } else  if (result > 18.5f && result <= 24.9f) {
            tvClassificacao.setTextColor(getColor(R.color.peso_normal))
            "PESO NORMAL"
        } else if (result > 25f && result <= 29.9f) {
            tvClassificacao.setTextColor(getColor(R.color.excesso_de_peso))
            "EXCESSO DE PESO"
        } else if (result > 30f && result <= 34.9f) {
            tvClassificacao.setTextColor(getColor(R.color.obesidade_classeI))
            "OBESIDADE CLASSE I"
        } else if (result > 35f && result <= 39.9f){
            tvClassificacao.setTextColor(getColor(R.color.obesidade_classeII))
            "OBESIDADE CLASSE II"
        } else {
            tvClassificacao.setTextColor(getColor(R.color.obesidade_morbida))
            "OBESIDADE MORBIDA"
        }
        tvClassificacao.text = classificacao
    }
}