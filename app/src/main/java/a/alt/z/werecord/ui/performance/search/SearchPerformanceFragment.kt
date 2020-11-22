package a.alt.z.werecord.ui.performance.search

import a.alt.z.werecord.R
import a.alt.z.werecord.databinding.FragmentSearchPerformanceBinding
import a.alt.z.werecord.util.viewBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchPerformanceFragment: Fragment(R.layout.fragment_search_performance) {

    private val binding by viewBinding(FragmentSearchPerformanceBinding::bind)

    private val viewModel: SearchPerformanceViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {

    }
}