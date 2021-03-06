package io.github.feelfreelinux.wykopmobilny.ui.modules.mikroblog.feed.hot

import io.github.feelfreelinux.wykopmobilny.base.BaseView
import io.github.feelfreelinux.wykopmobilny.models.dataclass.Entry
import io.github.feelfreelinux.wykopmobilny.ui.fragments.entries.EntriesFragmentView

interface HotView : BaseView {
    fun showHotEntries(entries : List<Entry>, isRefreshing : Boolean)
    fun disableLoading()
}