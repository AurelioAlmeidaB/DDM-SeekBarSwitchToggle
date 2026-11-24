    package com.example.ddm9

    import android.content.Intent
    import android.os.Bundle
    import android.widget.SeekBar
    import android.widget.Toast
    import androidx.activity.enableEdgeToEdge
    import androidx.appcompat.app.AppCompatActivity
    import androidx.core.view.ViewCompat
    import androidx.core.view.WindowInsetsCompat
    import com.example.ddm9.databinding.ActivityMainBinding
    import kotlin.jvm.java

    class MainActivity : AppCompatActivity() {

        private lateinit var binding: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
            configurarSeekBar()

            binding.btnSegActivity.setOnClickListener {
                abriSegundaTela()
            }
        }

        private fun configurarSeekBar() {
            binding.seekBarProgresso.setOnSeekBarChangeListener(
                object : SeekBar.OnSeekBarChangeListener {
                    override fun onProgressChanged(bar: SeekBar, progress: Int, fromUser: Boolean) {
                        binding.txtResultado.text ="Valor: $progress"
                    }

                    override fun onStartTrackingTouch(bar: SeekBar) {
                        Toast.makeText(
                            this@MainActivity,
                            "Ajustando o valor",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onStopTrackingTouch(bar: SeekBar) {
                        Toast.makeText(
                            this@MainActivity,
                            "Ajuste concluído",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            )
        }

        private fun abriSegundaTela(){
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }



    }