package david.hosseini.hearthstone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import david.hosseini.hearthstone.widget.SearchListener
import kotlinx.android.synthetic.main.activity_cards.*


class ItemListActivity : AppCompatActivity(), SearchListener {


    private val adapter = CardsAdapter()
    lateinit var viewModel: ItemsListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cards)

        viewModel = ViewModelProviders.of(this).get(ItemsListViewModel::class.java)

        observeViewModel(viewModel)

        setupView()
    }


    override fun onSearch(keyword: String) {

        viewModel.search(keyword)
    }


    override fun onDismiss() {
        adapter.clear()
    }


    private fun setupView() {
        setSupportActionBar(toolbar)

        recycler_cards.layoutManager = GridLayoutManager(this, 3)

        recycler_cards.adapter = adapter

        toolbar.setSearchListener(this)
    }


    private fun observeViewModel(viewModel: ItemsListViewModel) {

        viewModel.cardsLiveData.observe(this, Observer {

            adapter.setItems(it)
        })
    }

}
