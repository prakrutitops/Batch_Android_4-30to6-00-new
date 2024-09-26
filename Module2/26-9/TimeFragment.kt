package com.example.uicomponentex

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class TimeFragment :DialogFragment(), TimePickerDialog.OnTimeSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        var c= Calendar.getInstance()
        var sec = c.get(Calendar.SECOND)
        var minute = c.get(Calendar.MINUTE)
        var hour = c.get(Calendar.HOUR_OF_DAY)

        return TimePickerDialog(requireActivity(),this,hour,minute,true)
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int)
    {
        Toast.makeText(requireActivity(), ""+hourOfDay+"-"+minute+"-", Toast.LENGTH_SHORT).show()
    }


}