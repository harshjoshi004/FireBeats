package com.example.firebeats.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.firebeats.MainViewModel
import com.example.firebeats.R
@Preview
@Composable
fun AccountView() {
    Column {
        UserCard()
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
            Icon(painter = painterResource(id = R.drawable.baseline_audiotrack_24), contentDescription = null)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "My Music")
        }
        Divider(modifier = Modifier.height(3.dp), color = MaterialTheme.colorScheme.secondaryContainer)

    }
}

@Composable
fun UserCard(){
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, end = 8.dp, start = 8.dp, bottom = 8.dp)//outer
            .background(MaterialTheme.colorScheme.secondaryContainer)
            .padding(8.dp),//inner
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.AccountBox, contentDescription = null,
                Modifier
                    .size(48.dp)
                    .padding(end = 16.dp))
            Column {
                Text(text = "Harsh Joshi", fontSize = 18.sp)
                Text(text = "theharshjoshi2@gmail.com", fontSize = 12.sp, fontWeight = FontWeight.Light)
            }
        }
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Info, contentDescription = null, Modifier.size(32.dp))
        }
    }
}