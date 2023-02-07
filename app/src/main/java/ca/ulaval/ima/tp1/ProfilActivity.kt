package ca.ulaval.ima.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.*

class ProfilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        val myProfil = intent.getParcelableExtra<Profil>("profil")

        val firstNameTxt = findViewById<TextView>(R.id.FirstNameTxt)
        val lastNameTxt = findViewById<TextView>(R.id.LastNameTxt)
        val birthDateTxt = findViewById<TextView>(R.id.BirthDateTxt)
        val idulTxt = findViewById<TextView>(R.id.IdulTxt)


        if(myProfil != null) {
            firstNameTxt.text = myProfil.firstName
            lastNameTxt.text = myProfil.lastName
            val bDate = myProfil.birthDate
            birthDateTxt.text = "${bDate.get(Calendar.DATE)}/${bDate.get(Calendar.MONTH)}/${bDate.get(Calendar.YEAR)}"
            idulTxt.text = myProfil.idul
        }
    }
}