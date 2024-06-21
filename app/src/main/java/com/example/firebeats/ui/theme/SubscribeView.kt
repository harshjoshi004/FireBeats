package com.example.firebeats.ui.theme


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun SubscribeView() {
    LazyColumn{
        item {
            Text(text = "Manage Subscriptions ", modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp), textAlign = TextAlign.Center)
        }
        items(6) { SubCard() }
        item {Spacer(modifier = Modifier.size(16.dp))}
    }
}

@Composable
fun SubCard(){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp),
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(
            hoveredElevation = 10.dp
        )
    ) {
        Text(text = "Musical", modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp), textAlign = TextAlign.Start)
        Text(text = "Free Tier", modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 16.dp), textAlign = TextAlign.Start)
        ElevatedButton(onClick = { /*TODO*/ }, modifier = Modifier
            .align(Alignment.End)
            .padding(8.dp)) {
            Text(text = "See All Plans")
        }
        Divider()
        TextButton(onClick = { /*TODO*/ } , modifier = Modifier.padding(8.dp)){
            Icon(Icons.Default.AccountBox, contentDescription = null)
            Spacer(modifier = Modifier.size(8.dp))
            Text(text = "Get a Plan")
        }
    }
}