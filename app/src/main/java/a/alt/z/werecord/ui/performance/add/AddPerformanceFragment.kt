package a.alt.z.werecord.ui.performance.add

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import a.alt.z.werecord.R
import a.alt.z.werecord.databinding.FragmentAddPerformanceBinding
import a.alt.z.werecord.util.viewBinding
import androidx.fragment.app.viewModels

class AddPerformanceFragment: Fragment(R.layout.fragment_add_performance) {

    private val binding by viewBinding(FragmentAddPerformanceBinding::bind)

    private val viewModel: AddPerformanceViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun init() {

    }
}