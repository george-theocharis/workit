package gr.gap.workit.presentation.AddCustomerView

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import gr.gap.workit.R

class AddCustomerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_customer)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.stay, R.anim.slide_down)
    }
}
