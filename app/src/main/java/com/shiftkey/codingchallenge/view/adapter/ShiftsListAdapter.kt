package com.shiftkey.codingchallenge.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.shiftkey.codingchallenge.R
import com.shiftkey.codingchallenge.data.model.Shift
import com.shiftkey.codingchallenge.databinding.ItemShiftMainBinding

class ShiftsListAdapter(private val shifts: MutableList<Shift>, private val onClick: (id: Int) -> Unit): RecyclerView.Adapter<ShiftsListAdapter.ShiftHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShiftHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = DataBindingUtil.inflate<ItemShiftMainBinding>(
            layoutInflater,
            R.layout.item_shift_main,
            parent,
            false
        )
        return ShiftHolder(binding)
    }

    override fun onBindViewHolder(holder: ShiftHolder, position: Int) {
        val shift = shifts[position]
        holder.binding.shift = shift
        holder.binding.covid.visibility = if (shift.covid) View.VISIBLE else View.INVISIBLE
        holder.binding.covid.visibility = if (shift.premiumRate) View.VISIBLE else View.INVISIBLE
        holder.binding.root.setOnClickListener {
            onClick(shift.id)
        }
    }

    override fun getItemCount() = shifts.size

    fun setShifts(shiftsList: List<Shift>) {
        this.shifts.clear()
        this.shifts.addAll(shiftsList)
        notifyDataSetChanged()
    }

    inner class ShiftHolder(val binding: ItemShiftMainBinding): RecyclerView.ViewHolder(binding.root)
}