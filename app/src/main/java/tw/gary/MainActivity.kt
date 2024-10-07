package tw.gary

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() ,OnClickListener ,OnLongClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var txv: TextView = findViewById(R.id.txv)
        txv.text = "物件導向實例"

        var v3 = Three(55, 6, 21)
        txv.text = v3.Sum().toString() + "\n" + v3.Avg().toString()

        var img: ImageView = findViewById(R.id.img)
        img.setOnClickListener(this)
        txv.setOnClickListener(this)
        img.setOnLongClickListener(this)
    }

    override fun onClick(v: View?) {
        var txv: TextView = findViewById(R.id.txv)
        var img: TextView = findViewById(R.id.txv)
        if (v == txv) {
            txv.text = "文字短按"
        } else {
            txv.text = "可愛狐狸"
        }
    }

    override fun onLongClick(p0: View?): Boolean {
        var txv: TextView = findViewById(R.id.txv)
        txv.text = "狐狸長按"
        return true
    }


    interface Average {
        fun Avg(): Float
    }


    open class Two(var x: Int, var y: Int) {
        open fun Sum(): Int {
            return x + y
        }
    }

    class Three(x: Int, y: Int, var z: Int) : Two(x, y), Average {
        override fun Sum(): Int {
            return x + y + z
        }

        override fun Avg(): Float {
            return (x + y + z).toFloat() / 3
        }
    }
}


