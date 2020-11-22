package a.alt.z.werecord.data.prefs

import android.content.Context
import android.content.Context.MODE_PRIVATE
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TmdbPreferenceStorage @Inject constructor(
    @ApplicationContext context: Context
): PreferenceStorage {

    private val preferences = lazy { context.getSharedPreferences(PREFERENCES_NAME, MODE_PRIVATE) }

    companion object {
        const val PREFERENCES_NAME = "tmdb"
    }
}