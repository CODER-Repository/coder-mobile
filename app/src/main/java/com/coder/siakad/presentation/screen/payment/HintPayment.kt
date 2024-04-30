package com.coder.siakad.presentation.screen.payment

import android.icu.text.NumberFormat
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Cancel
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.coder.siakad.R
import java.util.Locale

@RequiresApi(Build.VERSION_CODES.N)
@Composable
fun HintPayment(
    bankName: String,
    va: String,
    accName: String,
    nominal: Long,
){
    OutlinedCard(modifier = Modifier.padding(24.dp)) {
        Column(modifier = Modifier.padding(top = 24.dp, start = 24.dp, end = 24.dp)) {
            Row(modifier = Modifier.width(350.dp)){
                Text(text = "Petunjuk Pembayaran",
                    style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .weight(1f)
                        .padding(5.dp)
                )
                IconButton(onClick = {}, modifier = Modifier.size(30.dp)) {
                    Icon(Icons.Filled.Cancel, contentDescription = "Cancel")
                }
            }
        }
        Divider(Modifier.padding(top = 8.dp))
        Column(modifier = Modifier.padding(24.dp)) {
            KrsNotification(
                info = stringResource(id = R.string.auto_verify_notif),
                backgroundColor = Color(0xFFAFC2DD),
                textColor = Color(0xFF245399),
                rectangleWidth = 10.dp,
            )
            Text(
                text = bankName,
                style = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
                color = Color(0xFF245399),
                modifier = Modifier.padding(top = 32.dp)
            )
            Text(
                text = "Silahkan transfer ke nomor rekening berikut",
                style = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Light),
                modifier = Modifier.padding(top = 6.dp)
            )
            Row {
                Text(
                    text = "Nama Bank",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Light),
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .width(120.dp)
                )
                Text(
                    text = ":",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .padding(top = 16.dp, start = 4.dp)
                )
                Text(
                    text = bankName,
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(top = 16.dp, start = 4.dp)
                )
            }
            Row {
                Text(
                    text = "Nomor Rekening VA",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Light),
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .width(120.dp)
                )
                Text(
                    text = ":",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .padding(top = 16.dp, start = 4.dp)
                )
                Text(
                    text = va,
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(top = 16.dp, start = 4.dp)
                )
            }
            Row {
                Text(
                    text = "Nama Akun",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Light),
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .width(120.dp)
                )
                Text(
                    text = ":",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .padding(top = 16.dp, start = 4.dp)
                )
                Text(
                    text = accName,
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(top = 16.dp, start = 4.dp)
                )
            }
            Row {
                Text(
                    text = "Nominal",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Light),
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .width(120.dp)
                )
                Text(
                    text = ": Rp",
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier
                        .padding(top = 16.dp, start = 4.dp)
                )
                Text(
                    text = NumberFormat.getNumberInstance(Locale("in")).format(nominal),
                    style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(top = 16.dp, start = 4.dp)
                )
            }
        }
        Divider(Modifier.padding(top = 8.dp))
        Column(modifier = Modifier.padding(24.dp)) {
            Text(text = "Setelah anda melakukan transfer, transaksi akan diverifikasi secara otomatis",
                style = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Light),
            )
        }
    }
}

 @Preview
@Composable
fun DefaultPreviewPaymentMethod(){
    HintPayment(
        bankName = "CIMB Niaga / CIMB Niaga Syariah",
        va = "25170122110928",
        accName = "UAJY Husni Mubarok",
        nominal = 8500000
    )
}