package fr.isen.mouillot.soundpacerunnersapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.isen.mouillot.soundpacerunnersapplication.ui.theme.SoundPaceRunnersApplicationTheme

class ContactForm : ComponentActivity() {
    @SuppressLint("IntentReset")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recipientEditText = findViewById<EditText>(R.id.etRecipientEmail)
        val subjectEditText = findViewById<EditText>(R.id.etSubject)
        val messageEditText = findViewById<EditText>(R.id.etMessage)
        val sendEmailButton = findViewById<Button>(R.id.btnSendEmail)

        sendEmailButton.setOnClickListener{
            val recipient = recipientEditText.text.toString().trim()
            val subject = subjectEditText.text.toString().trim()
            val message = messageEditText.text.toString().trim()

            val mIntent = Intent(Intent.ACTION_SEND)

            mIntent.data = Uri.parse("mailto:")
            mIntent.type = "text/plain"
            mIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(recipient))
            mIntent.putExtra(Intent.EXTRA_SUBJECT, subject)
            mIntent.putExtra(Intent.EXTRA_TEXT, message)

            try {
                startActivity(Intent.createChooser(mIntent,"Send Email"))

            }catch (e: Exception){
                Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()

            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SoundPaceRunnersApplicationTheme {
        Greeting("Android")
    }
}