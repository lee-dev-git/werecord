package a.alt.z.werecord.util.transformers

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs
import kotlin.math.max

class ZoomOutPageTransformer: ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        page.apply {
            when {
                position < -1 -> { alpha = 0F }
                position <= 1 -> {
                    val scaleFactor = max(MIN_SCALE, 1 - abs(position))

                    val verticalMargin = height * (1 - scaleFactor) / 2
                    val horizontalMargin = width * (1 - scaleFactor) / 2

                    translationX =
                        if(position < 0) horizontalMargin - verticalMargin / 2
                        else horizontalMargin + verticalMargin / 2

                    scaleX = scaleFactor
                    scaleY = scaleFactor

                    alpha = MIN_ALPHA + ((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)
                }
                else -> { alpha = 0F }
            }
        }
    }

    companion object {
        private const val MIN_SCALE = 0.85F
        private const val MIN_ALPHA = 0.5F
    }
}