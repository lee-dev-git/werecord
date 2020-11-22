package a.alt.z.werecord.ui

import a.alt.z.werecord.R
import a.alt.z.werecord.databinding.ActivityMainBinding
import a.alt.z.werecord.ui.movie.trending.TrendingMoviesFragment
import a.alt.z.werecord.util.viewBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        supportFragmentManager.commit { replace(R.id.mainRootLayout, TrendingMoviesFragment(), null) }
    }
}