package com.pigmal.lab.lifecycle

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


private const val ARG_INDEX = "param1"

class MyFragment : Fragment() {
    private var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            index = it.getInt(ARG_INDEX, 0)
        }
    }

    override fun onStart() {
        super.onStart()
        trace()
    }

    override fun onResume() {
        super.onResume()
        trace()
    }

    override fun onPause() {
        super.onPause()
        trace()
    }

    override fun onStop() {
        super.onStop()
        trace()
    }

    override fun onDestroy() {
        super.onDestroy()
        trace()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        trace()
        return inflater.inflate(R.layout.fragment_my, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        view?.findViewById<TextView>(R.id.text)?.text = "Fragment ${index}"
        trace()
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        trace()
    }

    override fun onDetach() {
        super.onDetach()
        trace()
    }

    companion object {
        @JvmStatic
        fun newInstance(index: Int) =
                MyFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_INDEX, index)
                    }
                }
    }
}
