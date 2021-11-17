package study.com.finaltask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val LAST_SELECTED_ITEM = "LAST_SELECTED_ITEM"
private val NUMBER_FRAGMENT = NumberFragment().javaClass.name
private val DICE_FRAGMENT = DiceFragment().javaClass.name

class MainActivity : AppCompatActivity() {

    private var numberFragment  = NumberFragment()
    private var diceFragment = DiceFragment()

    private lateinit var bottomNavigationMenu: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationMenu = findViewById(R.id.bottom_navigation_menu)

        bottomNavigationMenu.setOnItemSelectedListener { item ->

            var fragment: Fragment? = null

            when (item.itemId) {
                R.id.number -> {
                    fragment = savedInstanceState?.let {
                        supportFragmentManager.getFragment(it, NUMBER_FRAGMENT)
                    } ?: numberFragment
                }
                R.id.dice -> {
                    fragment = savedInstanceState?.let {
                        supportFragmentManager.getFragment(it, DICE_FRAGMENT)
                    } ?: diceFragment
                }
            }
            replaceFragment(fragment!!)
            true
        }

        bottomNavigationMenu.selectedItemId =
            savedInstanceState?.getInt(LAST_SELECTED_ITEM) ?: R.id.number


        val thankButton: Button = findViewById(R.id.thank_button)
        val intent = Intent(this, ThankActivity::class.java)
        thankButton.setOnClickListener {
            startActivity(intent)
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(LAST_SELECTED_ITEM, bottomNavigationMenu.selectedItemId)
        val fragment = supportFragmentManager.fragments.last()
        supportFragmentManager.putFragment(outState, fragment.javaClass.name, fragment)
        super.onSaveInstanceState(outState)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}