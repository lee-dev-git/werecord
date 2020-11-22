package a.alt.z.werecord.initializer

import android.content.Context
import androidx.startup.Initializer
import timber.log.Timber

class TimberInitializer: Initializer<Unit> {

    override fun create(context: Context) {
        Timber.plant(Timber.DebugTree())
        Timber.d("timber initialized")
    }

    override fun dependencies(): List<Class<out Initializer<*>>> = emptyList()
}