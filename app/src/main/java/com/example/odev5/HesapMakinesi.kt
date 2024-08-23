import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.odev5.ButonTiklama

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HesapMakinesi() {

    val gosterimMetni = remember { mutableStateOf("") }
    val mevcutGirdi = remember { mutableStateOf("") }
    val sonuc = remember { mutableStateOf<String?>(null) }
    val birSonrakiGirdiSifirlansinMi = remember { mutableStateOf(false) }


    Scaffold(topBar = { TopAppBar(title = { Text(text = "Hesap Makinesi") }) }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = sonuc.value ?: gosterimMetni.value + mevcutGirdi.value,
                modifier = Modifier.padding(30.dp),
            )

            val buttons = listOf(
                listOf("C", "+", "="),
                listOf("1", "2", "3"),
                listOf("4", "5", "6"),
                listOf("7", "8", "9"),
                listOf("0")
            )

            buttons.forEach { rowButtons ->
                Row {
                    rowButtons.forEach { text ->
                        HesapMakinesiButon(text) {
                            ButonTiklama(text, gosterimMetni, mevcutGirdi, sonuc, birSonrakiGirdiSifirlansinMi)
                        }
                    }
                }
            }
        }
    }
}





