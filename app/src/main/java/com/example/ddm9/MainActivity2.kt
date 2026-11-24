package com.example.ddm9

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ddm9.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnVerificar.setOnClickListener {
            verificar()
        }
        binding.switch1.setOnClickListener {
            ativarToggle()
            ativarCheckBox()
        }
    }

    private fun ativarToggle(){
        if (binding.switch1.isChecked){
            binding.toggleButton.isEnabled=true
        }
        else {
            binding.toggleButton.isEnabled=false
        }
    }

    private fun ativarCheckBox(){
        if(binding.switch1.isChecked){
            binding.cbSelecionar.isEnabled=true
        }
        else{
            binding.cbSelecionar.isEnabled=false
        }
    }

    private fun verificar(){
        binding.txtResSwitch.text =
            if(binding.switch1.isChecked)
                "Ligado"
            else
                "Desligado"

        binding.txtResToggle.text =
            if(binding.toggleButton.isChecked)
                "Toggle Ligado"
            else
                "Toggle desligado"
        binding.txtResCheckBox.text =
            if(binding.cbSelecionar.isChecked)
                "CheckBox selecionado"
            else
                "CheckBox não selecionado"
    }
}