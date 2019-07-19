package david.hosseini.hearthstone.widget

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.appcompat.widget.Toolbar
import david.hosseini.hearthstone.R
import kotlinx.android.synthetic.main.view_search_toolbar.view.*

class SearchToolbar : Toolbar {

    private lateinit var searchListener: SearchListener
    private var isSearching = false

    //it toggle between search and deleteAll button. at start it shows search image after click on it changes to deleteAll button
    private lateinit var searchAndClearButton: ImageButton
    private lateinit var searchEditText: EditText
    private lateinit var title: TextView

    private val searchTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

        }

        override fun afterTextChanged(text: Editable) {
            if (text.isEmpty() && isSearching) {
                searchAndClearButton.alpha = 0.6f
                searchListener.onDismiss()
            } else {
                searchAndClearButton.alpha = 1.0f
                searchListener.onSearch(text.toString())
            }
        }
    }

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }


    private fun init() {

        LayoutInflater.from(context).inflate(R.layout.view_search_toolbar, this, true)

        title = findViewById(R.id.toolbar_title)
        searchAndClearButton = findViewById(R.id.toolbar_search)
        searchEditText = findViewById(R.id.search_edit_text)

        title.setText(R.string.app_name)


        searchEditText.addTextChangedListener(searchTextWatcher)

        search_toolbar_back.setOnClickListener {
            search_toolbar_back.visibility = View.INVISIBLE
            searchAndClearButton.alpha = 1.0f
            searchAndClearButton.setImageResource(R.drawable.ic_search)
            searchEditText.visibility = View.GONE
            title.visibility = View.VISIBLE

            isSearching = false
            searchEditText.setText("")
            searchListener.onDismiss()

        }

        searchAndClearButton.setOnClickListener {

            if (!isSearching) {

                searchAndClearButton.setImageResource(R.drawable.ic_close)
                searchAndClearButton.alpha = 0.6f
                searchEditText.visibility = View.VISIBLE
                search_toolbar_back.visibility = View.VISIBLE
                searchEditText.requestFocus()
                title.visibility = View.INVISIBLE

                isSearching = true

            } else if (searchEditText.text.isNotEmpty()) {
                searchEditText.setText("")
                searchListener.onDismiss()
            }
        }
    }


    override fun setTitle(@StringRes resId: Int) {
        title.setText(resId)
    }

    fun setSearchListener(searchListener: SearchListener) {
        this.searchListener = searchListener
    }
}
