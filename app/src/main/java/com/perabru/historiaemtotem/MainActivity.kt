package com.perabru.historiaemtotem

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.speech.tts.TextToSpeech
import android.widget.ImageButton

import java.util.*

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private lateinit var tts: TextToSpeech

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tts = TextToSpeech(this, this)

        val narracoes = mapOf(
            R.id.btnEvento1 to "Evento 1: Demolições e Gabinete Médico – c. 1903\n"+
                    "Nesta imagem vemos trabalhadores demolindo cortiços sob ordens do governo durante a reforma urbana. Ao fundo, um gabinete médico com a placa \"Dr. Osvaldo Cruz\". Representa o início das reformas sanitárias e os impactos violentos para as populações pobres, com despejos forçados.\n"+
                    "Data aproximada: 1903, início da campanha sanitarista.",

            R.id.btnEvento2 to "Evento 2: Fila de Vacinação – c. 2021 (paralelo contemporâneo)\n"+
                    "Mulheres em fila para vacinação em um cenário atual. Representa um contraponto contemporâneo, destacando como a percepção sobre vacinas mudou com o tempo, após anos de campanhas de conscientização e valorização da ciência.\n"+
                    "Data aproximada: 2021, contexto da COVID-19.",

            R.id.btnEvento3 to "Evento 3: Família sendo abordada – c. 1904\n"+
                    "Uma família assustada é surpreendida por autoridades militares. Mostra a coerção e medo gerados pela imposição da vacina e pelas operações de remoção e fiscalização sanitária sem consentimento.\n"+
                    "Data aproximada: novembro de 1904, auge da repressão durante a revolta.",

            R.id.btnEvento4 to "Evento 4: Protesto contra a vacinação – c. 1904\n"+
                    "Ilustração dramática de manifestantes com cartazes “Abaixo a Vacinação”, enfrentando autoridades. Representa o estopim da revolta: a insatisfação popular, o medo da vacina e a indignação com a repressão.\n"+
                    "Data: 10 de novembro de 1904 (início da revolta).",

            R.id.btnEvento5 to "Evento 5: Confronto armado nas ruas – c. 1904\n"+
                    "Soldados reprimem com violência uma revolta popular. Representa o ápice do conflito urbano, quando o governo utilizou o Exército para conter a população rebelada.\n"+
                    "Data: entre 12 e 16 de novembro de 1904.",

            R.id.btnEvento6 to "Evento 6: Apresentação da vacina à população – c. 1904\n"+
                    "Dois médicos apresentam a seringa a uma família pobre e desconfiada. A cena simboliza a falta de comunicação e diálogo do governo com a população, que temia os efeitos da vacina e não compreendia seu funcionamento.\n"+
                    "Data aproximada: 1904, início da campanha de vacinação forçada.",

            R.id.btnEvento7 to "Evento 7: Disputa política no parlamento – c. 1904\n"+
                    "Políticos debatem acaloradamente sob a bandeira do Brasil. Representa os bastidores da crise: enquanto o povo protestava nas ruas, o parlamento e as elites decidiam os rumos da nação.\n"+
                    "Data: final de 1904, contexto da repercussão política da revolta.\n",

            R.id.btnEvento8 to "Evento 8: Cortiços e miséria infantil – c. 1903\n"+
                    "Crianças pobres em um cortiço abandonado. Mostra o cenário de miséria e insalubridade em que vivia grande parte da população, um dos principais focos das reformas de Oswaldo Cruz.\n"+
                    "Data: 1903-1904, antes das demolições dos cortiços.\n",

            R.id.btnEvento9 to "Evento 9: Cartaz oficial da campanha de vacinação – 1904\n"+
                    "Documento real da campanha anti-varíola. Explica os efeitos da vacina e sua obrigatoriedade. Era um dos materiais usados pelo governo para justificar a vacinação compulsória.\n"+
                    "Data: 1904, documento oficial do governo federal.",

            R.id.btnEvento10 to "Evento 10: Invasão e vacinação forçada – c. 1904\n"+
                    "Policiais invadem uma casa com seringas nas mãos, enquanto uma família se encolhe em medo. Representa a vacinação compulsória com força policial, símbolo máximo da falta de empatia com a população.\n"+
                    "Data: novembro de 1904, durante a revolta."
        )

        narracoes.forEach { (idBotao, texto) ->
            findViewById<ImageButton>(idBotao).setOnClickListener {
                narrarTexto(texto)
            }
        }
    }

    private fun narrarTexto(texto: String) {
        tts.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts.language = Locale("pt", "BR")
        }
    }

    override fun onDestroy() {
        if (tts.isSpeaking) {
            tts.stop()
        }
        tts.shutdown()
        super.onDestroy()
    }
}
