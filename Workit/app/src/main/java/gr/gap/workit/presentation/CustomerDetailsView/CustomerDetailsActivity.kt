package gr.gap.workit.presentation.CustomerDetailsView

import android.app.Fragment
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import gr.gap.workit.R
import gr.gap.workit.presentation.BooksView.BooksFragment
import kotlinx.android.synthetic.main.activity_customer_details.*

class CustomerDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_customer_details)

        supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, CustomerDetailsFragment(), "Info").commit()

        bottom_navigation.setOnNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.action_info -> addFragment(CustomerDetailsFragment(), "Info")
                    R.id.action_books -> addFragment(BooksFragment(), "Books")
                    else -> true
                }
        }
    }

    private fun addFragment(fragment: android.support.v4.app.Fragment, tag: String): Boolean{
        
        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment, tag).commit()

        return true
    }
}

