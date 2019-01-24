package com.example.engyousef.startjoe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    var isNewOP = false
    fun buNumbers(view:View){

        if(isNewOP){
            showNumbers.setText("")
        }
        isNewOP=false
       val buSelect = view as Button
       var Number:String=showNumbers.text.toString()
        when(buSelect.id){
            bu0.id->{Number+="0"}
            bu1.id->{Number+="1"}
            bu2.id->{Number+="2"}
            bu3.id->{Number+="3"}
            bu4.id->{Number+="4"}
            bu5.id->{Number+="5"}
            bu6.id->{Number+="6"}
            bu7.id->{Number+="7"}
            bu8.id->{Number+="8"}
            bu9.id->{Number+="9"}
            buDot.id->{
                //todo prevent adding more than 1 dot
                Number+="."}
            buPlusMinus.id->{Number="-"+Number}
        }
        showNumbers.setText(Number)
    }

    var op ="*"
    var oldNumber =""
    fun buOpEvent (view:View){

        val buSelect = view as Button
        when(buSelect.id){
            buMult.id->{op="*"}
            buDiv.id->{op="/"}
            buPlus.id->{op="+"}
            buMinus.id->{op="-"}
        }
       oldNumber=showNumbers.text.toString()
        isNewOP=true
    }

    fun buEqualEvent (view:View){
        val newNumber = showNumbers.text.toString()
        var finalNumber :Double?=null
        when(op){
            "*"->{finalNumber = oldNumber.toDouble() * newNumber.toDouble()}
            "/"->{finalNumber = oldNumber.toDouble() / newNumber.toDouble()}
            "+"->{finalNumber = oldNumber.toDouble() + newNumber.toDouble()}
            "-"->{finalNumber = oldNumber.toDouble() - newNumber.toDouble()}
        }
        showNumbers.setText(finalNumber.toString())
        isNewOP=true
    }

    fun buPerEvent(view:View){
        val number = showNumbers.text.toString().toDouble()/100
        showNumbers.setText(number.toString())
    }

    fun buCleanEvent (view:View){
        showNumbers.setText("")
        isNewOP=true
    }
}
