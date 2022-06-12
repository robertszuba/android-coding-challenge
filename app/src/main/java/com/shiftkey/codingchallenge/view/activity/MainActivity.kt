package com.shiftkey.codingchallenge.view.activity

import android.content.Intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.shiftkey.codingchallenge.databinding.ActivityMainBinding
import com.shiftkey.codingchallenge.view.adapter.ShiftsListAdapter
import com.shiftkey.codingchallenge.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private val adapter = ShiftsListAdapter(mutableListOf(), onClick = { id -> showShift(id)})
    private lateinit var viewModel: MainViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        initRecyclerView()
        showProgressbar()
    }

    private fun showShift(id: Int) {
        val intent = Intent(this, SingleShiftActivity::class.java).apply {
            putExtra(EXTRA_ID, id)
        }
        startActivity(intent)
    }

    private fun initRecyclerView() {
        binding.shiftsRecyclerView.adapter = adapter
        viewModel.getAllShifts().observe(this) { shifts ->
            hideProgressBar()
            shifts?.let {
                adapter.setShifts(it)
            }
        }
    }

    private fun showProgressbar() {
        binding.shiftsRecyclerView.isEnabled = false
        binding.progressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        binding.shiftsRecyclerView.isEnabled = true
        binding.progressBar.visibility = View.GONE
    }
}