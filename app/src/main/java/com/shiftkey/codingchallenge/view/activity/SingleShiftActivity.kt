package com.shiftkey.codingchallenge.view.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.shiftkey.codingchallenge.R
import com.shiftkey.codingchallenge.databinding.ActivitySingleShiftBinding
import com.shiftkey.codingchallenge.viewmodel.SingleShiftViewModel

const val EXTRA_ID = "shift_id"

class SingleShiftActivity : AppCompatActivity() {

    private lateinit var viewModel: SingleShiftViewModel
    private lateinit var binding: ActivitySingleShiftBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val id = intent.getIntExtra(EXTRA_ID, 0)
        binding = ActivitySingleShiftBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(SingleShiftViewModel::class.java)

        viewModel.searchShift(id).observe(this) { shift ->
            shift?.let {
                binding.shift = shift
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return true
    }
}