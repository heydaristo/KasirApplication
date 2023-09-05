package com.example.kasirheydar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.lang.Math.abs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val namaPembeli = findViewById<EditText>(R.id.namaPelanggan)
        val judulEbook = findViewById<EditText>(R.id.judulEbook)
        val jumlahBeli = findViewById<EditText>(R.id.jumlahBeli)
        val harga = findViewById<EditText>(R.id.harga)
        val uangBayar= findViewById<EditText>(R.id.uangBayar)
        val btnProses = findViewById<Button>(R.id.btnProses)
        val totalBelanja = findViewById<TextView>(R.id.totalbelanja)
        val uangKembali = findViewById<TextView>(R.id.uangKembali)
        val keterangan = findViewById<TextView>(R.id.keterangan)
        val btnReset = findViewById<Button>(R.id.btnReset)
        val bonus = findViewById<TextView>(R.id.bonus)

        btnProses.setOnClickListener {
            var total: Int = 0
            var uangkmbli: Int = 0
            val jmlhBeli = Integer.parseInt(jumlahBeli.text .toString())
            val harga = Integer.parseInt(harga.text.toString())
            val uangBayar = Integer.parseInt(uangBayar.text.toString())

            total = jmlhBeli * harga
            uangkmbli = uangBayar - harga

            totalBelanja.text = total.toString()
            uangKembali.text = uangkmbli.toString()

            if(uangBayar==total) {
                keterangan.text = "Keterangan: Uang Pas"
            } else if(uangBayar<total) {
                keterangan.text = "Keterangan: Kurang Bayar " + abs(uangkmbli)
            } else if(uangBayar>total) {
                keterangan.text = "Keterangan: Uang Pas " + uangkmbli
            } else if(total>= 200000) {
                bonus.text = "Bonus : Mouse"
            }
            if(total>= 400000) {
                bonus.text = "Bonus : Keyboard"
            }
            if(total>= 600000) {
                bonus.text = "Bonus : Hardisk"
            } else {
                bonus.text="Bonus: Tidak ada Bonus"
            }
        }
        btnReset.setOnClickListener {
            namaPembeli.setText(" ");
            judulEbook.setText(" ");
            totalBelanja.setText(" Total Belanja : Rp 0");
            harga.setText(" ");
            uangBayar.setText(" ");
            uangKembali.setText("Uang Kembali : Rp 0");
            bonus.setText("Bonus : - ");
            jumlahBeli.setText(" ");
            keterangan.setText("Keterangan : - ");

            Toast.makeText(getApplicationContext(),"Data sudah direset", Toast.LENGTH_LONG).show();
        }
    }
}