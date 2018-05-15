package gr.gap.workit.domain.utilities

import android.graphics.Color
import java.util.*
import kotlin.collections.ArrayList


class Utils{

    companion object {

        fun getDateFromTimeStamp(timestamp: String){

        }

        fun getTimeFromTimeStamp(timestamp: String){

        }

        fun getRandomColor():Int{
            val rnd = Random()
            return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256))
        }
    }

}