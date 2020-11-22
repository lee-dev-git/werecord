package a.alt.z.werecord.util.transformers

import android.view.View
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class DepthPageTransformer: ViewPager2.PageTransformer {

    override fun transformPage(page: View, position: Float) {
        page.apply {
            when {
                position < -1 -> { alpha = 0F }
                position <= 0 -> {
                    alpha = 1F
                    translationX = 0F
                    translationZ = 0F
                    scaleX = 1F
                    scaleY = 1F
                }
                position <= 1 -> {
                    alpha = 1 - position
                    translationX = width * -position
                    translationZ = -1F
                    val scaleFactor = MIN_SCALE + (1 - MIN_SCALE) * (1 - abs(position))
                    scaleX = scaleFactor
                    scaleY = scaleFactor
                }
                else -> { alpha = 0F }
            }
        }
    }

    companion object {
        private const val MIN_SCALE = 0.75F
    }
}