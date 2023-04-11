package ru.startandroid.develop.tabcontentfactory

import android.app.TabActivity
import android.os.Bundle
import android.widget.TabHost
import android.widget.TextView

const val TABS_TAG_1 = "Tag 1"
const val TABS_TAG_2 = "Tag 2"

class MainActivity : TabActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabHost = tabHost

        var tabSpec: TabHost.TabSpec

        tabSpec = tabHost.newTabSpec(TABS_TAG_1)
        tabSpec.setContent(tabFactory)
        tabSpec.setIndicator("Вкладка 1")
        tabHost.addTab(tabSpec)

        tabSpec = tabHost.newTabSpec(TABS_TAG_2)
        tabSpec.setContent(tabFactory)
        tabSpec.setIndicator("Вкладка 2")
        tabHost.addTab(tabSpec)
    }
    var tabFactory = TabHost.TabContentFactory { tag ->
        if (tag.equals(TABS_TAG_1)) {
            return@TabContentFactory layoutInflater.inflate(R.layout.tab, null)
        } else if (tag.equals(TABS_TAG_2)) {
            val tv = TextView(this@MainActivity)
            tv.text = "Это создано вручную"
            return@TabContentFactory tv
        }
        null
    }
}