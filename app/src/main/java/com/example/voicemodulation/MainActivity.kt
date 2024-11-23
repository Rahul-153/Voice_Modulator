import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.voicemodulation.CallActivity
import com.example.voicemodulation.R
import java.util.Random

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appID: Long = 0 // Initialize with appropriate value
        val appSign: String = "" // Initialize with appropriate value

        val userID = generateUserID()
        val userName = "${userID}_Name"
        val callID = "test_call_id"

        findViewById<View>(R.id.join_btn).setOnClickListener {
            val intent = Intent(this, CallActivity::class.java).apply {
                putExtra("appID", appID)
                putExtra("appSign", appSign)
                putExtra("userID", userID)
                putExtra("userName", userName)
                putExtra("callID", callID)
            }
            startActivity(intent)
        }
    }

    private fun generateUserID(): String {
        val builder = StringBuilder()
        val random = Random()
        while (builder.length < 5) {
            val nextInt = random.nextInt(10)
            if (builder.isEmpty() && nextInt == 0) {
                continue
            }
            builder.append(nextInt)
        }
        return builder.toString()
    }
}

