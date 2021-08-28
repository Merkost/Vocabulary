package ru.students.core

import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import ru.students.model.data.AppState
import ru.students.model.data.userdata.DataModel
import kotlinx.android.synthetic.main.loading_layout.*
import ru.students.utils.ui.AlertDialogFragment
import ru.students.vocabulary.utils.network.OnlineLiveData

abstract class BaseActivity<T : AppState, I : ru.students.core.viewmodel.Interactor<T>> :
    AppCompatActivity() {

    abstract val model: ru.students.core.viewmodel.BaseViewModel<T>

    protected var isNetworkAvailable: Boolean = true
    protected abstract val layoutRes: Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes)
        subscribeToNetworkChange()
    }

    private fun subscribeToNetworkChange() {
        OnlineLiveData(this).observe(
            this@BaseActivity,
            Observer<Boolean> {
                isNetworkAvailable = it
                if (!isNetworkAvailable) {
//                    Toast.makeText(
//                        this@BaseActivity,
//                        R.string.dialog_message_device_is_offline,
//                        Toast.LENGTH_LONG
//                    ).show()
                    Snackbar.make(
                        findViewById(layoutRes),
                        R.string.dialog_message_device_is_offline,
                        Snackbar.LENGTH_LONG
                    ).setAction("Connect") {
                        startActivity(Intent(WifiManager.ACTION_PICK_WIFI_NETWORK));
                    }.show()
                }
            })
    }

    protected fun showNoInternetConnectionDialog() {
        showAlertDialog(
            getString(R.string.dialog_title_device_is_offline),
            getString(R.string.dialog_message_device_is_offline)
        )
    }

    private fun showAlertDialog(title: String?, message: String?) {
        AlertDialogFragment.newInstance(title, message)
            .show(supportFragmentManager, DIALOG_FRAGMENT_TAG)
    }

    private fun isDialogNull(): Boolean {
        return supportFragmentManager.findFragmentByTag(DIALOG_FRAGMENT_TAG) == null
    }

    abstract fun setDataToAdapter(data: List<DataModel>)

    protected fun renderData(appState: T) {
        when (appState) {
            is AppState.Success -> {
                showViewWorking()
                appState.data?.let {
                    if (it.isEmpty()) {
                        showAlertDialog(
                            getString(R.string.dialog_tittle_sorry),
                            getString(R.string.empty_server_response_on_success)
                        )
                    } else {
                        setDataToAdapter(it)
                    }
                }
            }
            is AppState.Loading -> {
                showViewLoading()
                if (appState.progress != null) {
                    progress_bar_horizontal.visibility = View.VISIBLE
                    progress_bar_round.visibility = View.GONE
                    progress_bar_horizontal.progress = appState.progress!!
                } else {
                    progress_bar_horizontal.visibility = View.GONE
                    progress_bar_round.visibility = View.VISIBLE
                }
            }
            is AppState.Error -> {
                showViewWorking()
                showAlertDialog(getString(R.string.error_stub), appState.error.message)
            }
        }
    }

    companion object {
        private const val DIALOG_FRAGMENT_TAG = "74a54328-5d62-46bf-ab6b-cbf5d8c79522"
    }

    private fun showViewWorking() {
        loading_frame_layout_history.visibility = View.GONE
    }

    private fun showViewLoading() {
        loading_frame_layout_history.visibility = View.VISIBLE
    }

}

