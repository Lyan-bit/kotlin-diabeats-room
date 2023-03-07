package com.example.diabeats

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64

class DiabeatsRecyclerViewAdapter (items: List<DiabeatsEntity>, listener: ListDiabeatsFragment.OnListDiabeatsFragmentInteractionListener)
    : RecyclerView.Adapter<DiabeatsRecyclerViewAdapter.DiabeatsViewHolder>() {

    private var mValues: List<DiabeatsEntity> = items
    private var mListener: ListDiabeatsFragment.OnListDiabeatsFragmentInteractionListener = listener
	
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiabeatsViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recyclerviewlistdiabeats_item, parent, false)
        return DiabeatsViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: DiabeatsViewHolder, position: Int) {
        holder.mItem = mValues[position]
        holder.listDiabeatsIdView.text = " " + mValues[position].id + " "
        holder.listDiabeatsPregnanciesView.text = " " + mValues[position].pregnancies + " "
        holder.listDiabeatsGlucoseView.text = " " + mValues[position].glucose + " "
        holder.listDiabeatsBloodPressureView.text = " " + mValues[position].bloodPressure + " "
        holder.listDiabeatsSkinThicknessView.text = " " + mValues[position].skinThickness + " "
        holder.listDiabeatsInsulinView.text = " " + mValues[position].insulin + " "
        holder.listDiabeatsBmiView.text = " " + mValues[position].bmi + " "
        holder.listDiabeatsDiabetesPedigreeFunctionView.text = " " + mValues[position].diabetesPedigreeFunction + " "
        holder.listDiabeatsAgeView.text = " " + mValues[position].age + " "
        holder.listDiabeatsOutcomeView.text = " " + mValues[position].outcome + " "

        holder.mView.setOnClickListener { mListener.onListDiabeatsFragmentInteraction(holder.mItem) }
    }
    
    override fun getItemCount(): Int {
        return mValues.size
    }

    inner class DiabeatsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var mView: View
        var listDiabeatsIdView: TextView
        var listDiabeatsPregnanciesView: TextView
        var listDiabeatsGlucoseView: TextView
        var listDiabeatsBloodPressureView: TextView
        var listDiabeatsSkinThicknessView: TextView
        var listDiabeatsInsulinView: TextView
        var listDiabeatsBmiView: TextView
        var listDiabeatsDiabetesPedigreeFunctionView: TextView
        var listDiabeatsAgeView: TextView
        var listDiabeatsOutcomeView: TextView
        lateinit var mItem: DiabeatsEntity

        init {
            mView = view
            listDiabeatsIdView = view.findViewById(R.id.listDiabeatsIdView)
            listDiabeatsPregnanciesView = view.findViewById(R.id.listDiabeatsPregnanciesView)
            listDiabeatsGlucoseView = view.findViewById(R.id.listDiabeatsGlucoseView)
            listDiabeatsBloodPressureView = view.findViewById(R.id.listDiabeatsBloodPressureView)
            listDiabeatsSkinThicknessView = view.findViewById(R.id.listDiabeatsSkinThicknessView)
            listDiabeatsInsulinView = view.findViewById(R.id.listDiabeatsInsulinView)
            listDiabeatsBmiView = view.findViewById(R.id.listDiabeatsBmiView)
            listDiabeatsDiabetesPedigreeFunctionView = view.findViewById(R.id.listDiabeatsDiabetesPedigreeFunctionView)
            listDiabeatsAgeView = view.findViewById(R.id.listDiabeatsAgeView)
            listDiabeatsOutcomeView = view.findViewById(R.id.listDiabeatsOutcomeView)
        }

        override fun toString(): String {
            return super.toString() + " " + mItem
        }

    }
}
