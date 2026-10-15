package com.example.tugas4_pam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tugas4_pam.ui.theme.Tugas4_PAMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Tugas4_PAMTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun CounterScreen(
    modifier: Modifier = Modifier,
    viewModel: CounterViewModel = viewModel()
) {
    val count by viewModel.count.collectAsState()

    val primaryDark = Color(0xFF212842)
    val pastelAccent = Color(0xFFFCD3DE)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Aryanti Puspita Sari",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = primaryDark
        )
        Text(
            text = "NIM: 245150400111068",
            fontSize = 16.sp,
            color = primaryDark,
            modifier = Modifier.padding(top = 4.dp)
        )

        Spacer(modifier = Modifier.height(48.dp))

        Text(
            text = "$count",
            fontSize = 72.sp,
            fontWeight = FontWeight.ExtraBold,
            color = primaryDark
        )

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { viewModel.decrement() },
                colors = ButtonDefaults.buttonColors(containerColor = primaryDark),
                modifier = Modifier.weight(1f)
            ) {
                Text("Down", color = pastelAccent)
            }

            Button(
                onClick = { viewModel.increment() },
                colors = ButtonDefaults.buttonColors(containerColor = primaryDark),
                modifier = Modifier.weight(1f)
            ) {
                Text("Up", color = pastelAccent)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { viewModel.reset() },
            colors = ButtonDefaults.buttonColors(containerColor = pastelAccent),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Reset", color = primaryDark, fontWeight = FontWeight.Bold)
        }
    }
}