package ca.ulaval.ima.tp1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.widget.Button
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val websiteExtButton = findViewById<Button>(R.id.WebsiteExtBtn)
        val websiteWvButton = findViewById<Button>(R.id.WebsiteWvBtn)
        val ulavalButton = findViewById<Button>(R.id.ULavalBtn)
        val profilButton = findViewById<Button>(R.id.ProfileBtn)

        val myProfil = Profil("Etienne",
            "cloutier" ,
            Calendar.getInstance().apply { set(2000,4,26) },
            "ETCLO5")
        val UrlToLoad = "https://www.google.com"


        websiteExtButton.setOnClickListener(){
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(UrlToLoad))
            startActivity(intent)
        }
        websiteWvButton.setOnClickListener(){
            val intent = Intent(this, WebsiteActivity::class.java)
            intent.putExtra("url", UrlToLoad)
            startActivity(intent)
        }
        ulavalButton.setOnClickListener(){
            val intent = Intent(this, UlavalActivity::class.java)
            startActivity(intent)
        }
        profilButton.setOnClickListener(){
            val intent = Intent(this, ProfilActivity::class.java)
            intent.putExtra("profil", myProfil)
            startActivity(intent)
        }

    }

}

class Profil(var firstName: String, var lastName: String, var birthDate: Calendar, var idul: String) : Parcelable {
    companion object {
        @JvmField
        val CREATOR = object : Parcelable.Creator<Profil>{
            override fun createFromParcel(parcel: Parcel) = Profil(parcel)
            override fun newArray(size: Int) = arrayOfNulls<Profil>(size)
        }
    }
    constructor(parcel: Parcel) : this(
        firstName = parcel.readString() ?: "",
        lastName = parcel.readString() ?: "",
        birthDate = parcel.readSerializable() as Calendar,
        idul = parcel.readString() ?: ""
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeSerializable(birthDate)
        parcel.writeString(idul)
    }
}