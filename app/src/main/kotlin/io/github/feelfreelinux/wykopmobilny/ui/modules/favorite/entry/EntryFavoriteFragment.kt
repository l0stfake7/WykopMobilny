package io.github.feelfreelinux.wykopmobilny.ui.modules.favorite.entry

import android.os.Bundle
import androidx.fragment.app.Fragment
import io.github.feelfreelinux.wykopmobilny.base.BaseEntriesFragment
import javax.inject.Inject

class EntryFavoriteFragment : BaseEntriesFragment(), EntryFavoriteView {
    @Inject
    lateinit var presenter: EntryFavoritePresenter
    override var loadDataListener: (Boolean) -> Unit = {
        presenter.loadData(it)
    }

    companion object {
        fun newInstance(): androidx.fragment.app.Fragment {
            return EntryFavoriteFragment()
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter.subscribe(this)
        entriesAdapter.entryActionListener = presenter
        entriesAdapter.loadNewDataListener = { loadDataListener(false) }
        presenter.loadData(true)
    }

    override fun onResume() {
        super.onResume()
        presenter.subscribe(this)
    }

    override fun onStop() {
        super.onStop()
        presenter.unsubscribe()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dispose()
    }
}