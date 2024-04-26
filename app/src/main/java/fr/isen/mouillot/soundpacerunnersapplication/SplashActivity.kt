package fr.isen.mouillot.soundpacerunnersapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import fr.isen.mouillot.soundpacerunnersapplication.MainActivity
import fr.isen.mouillot.soundpacerunnersapplication.R
import fr.isen.mouillot.soundpacerunnersapplication.ui.theme.SoundPaceRunnersApplicationTheme
import java.util.Timer
import kotlin.concurrent.timerTask

@SuppressLint("CustomSplashScreen")
class SplashActivity : ComponentActivity() {

    private val SPLASH_TIME_OUT: Long = 5000 // 5 secondes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Créer une ImageView pour afficher le logo
        //val imageView = ImageView(this)
        //imageView.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.logo_projet))

        setContent {
            SoundPaceRunnersApplicationTheme {
                // Cette coroutine attend le temps défini avant de démarrer l'activité suivante
                SplashScreenContentSPR()
            }
        }
        Timer().schedule(timerTask {
            navigateToNextScreen()
        }, SPLASH_TIME_OUT)


    }
    // Cette fonction est appelée lorsque le délai est écoulé, elle démarre l'activité suivante
    private fun navigateToNextScreen() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}

@Composable
fun SplashScreenContentSPR() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Ajouter un padding si nécessaire
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(350.dp) // Taille de l'image, ajustez selon vos besoins
                //.border(2.dp, Color.Black)
        ) {
            Image(
                painter = painterResource(id = R.drawable.soundpacerunnerslogo),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

