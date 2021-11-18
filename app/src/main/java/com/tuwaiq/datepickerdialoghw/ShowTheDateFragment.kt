package com.tuwaiq.datepickerdialoghw

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import java.text.DateFormat
import java.util.*

const val DATE_KYE = "dialog-date"

class ShowTheDateFragment : Fragment() , DatePickerDialogFragment.datePickerCallBack{

    private lateinit var dateBtn:Button
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=  inflater.inflate(R.layout.fragment_show_the_date,
            container, false)



        dateBtn = view.findViewById(R.id.date_btn)
        textView = view.findViewById(R.id.show_date)

        return view
    }

    override fun onStart() {
        super.onStart()

        dateBtn.setOnClickListener {
            val args = Bundle()
            args.putSerializable(DATE_KYE,dateBtn.toString())

            val datePicker=  DatePickerDialogFragment()
            datePicker.arguments=args
            datePicker.setTargetFragment(this,0)
            datePicker.show(this.parentFragmentManager,"date picker")
        }
    }

    override fun onDateSelected(date: Date) {
       // dateBtn.text= date.toString()
        textView.text = date.toString()
        textView.text= DateFormat.getDateInstance().format(date)


    }


}