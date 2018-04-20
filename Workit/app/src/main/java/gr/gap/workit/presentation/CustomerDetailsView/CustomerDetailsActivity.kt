package gr.gap.workit.presentation.CustomerDetailsView

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import gr.gap.workit.R
import gr.gap.workit.domain.model.Customer
import gr.gap.workit.presentation.BooksView.BooksFragment
import gr.gap.workit.presentation.TransactionsView.TransactionsFragment
import kotlinx.android.synthetic.main.activity_customer_details.*

class CustomerDetailsActivity : AppCompatActivity() {

    companion object {
        const val Info: String = "Info"
        const val Books: String = "Books"
        const val Transactions: String = "Transactions"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_customer_details)


        val customerId = intent.getIntExtra("customerId", 0)

        if(savedInstanceState == null)
             addFragment(CustomerDetailsFragment.create(customerId), Info)

        bottom_navigation.setOnNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.action_info ->  addFragment(CustomerDetailsFragment.create(customerId), Info)
                    R.id.action_books -> addFragment(BooksFragment(), Books)
                    R.id.action_transactions -> addFragment(TransactionsFragment(), Transactions)
                    else -> true
                }
        }
    }

    private fun addFragment(fragment: android.support.v4.app.Fragment, tag: String): Boolean{

        when(tag){
            Info -> fab.hide()
            else -> fab.show()
        }

        supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragment, tag).commit()

        return true
    }

    fun UpdateHeader(customer: Customer) {
        headerName.text= "${customer.firstName} ${customer.lastName}"
        customerIcon.text = customer.firstName[0].toString() + customer.lastName[0].toString()
    }
}

