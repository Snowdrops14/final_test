package study.com.finaltask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ThankActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thank)

        val thankList: List<String> = listOf(
            "Спасибо, мама!",
            "Спасибо, папа!",
            "Спасибо, Максим Витальевич!",
            "JetBrains, вам тоже спасибо!",
            "Всех-всех причастных обняла."
        )

        val thankRecyclerView: RecyclerView = findViewById(R.id.thank_recycler_view)
        thankRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        thankRecyclerView.adapter = ThankAdapter(thankList)

    }
}