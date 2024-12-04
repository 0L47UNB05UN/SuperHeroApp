package com.example.superheroapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroapp.ui.theme.SuperHeroAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperHeroAppTheme {
                Scaffold(
                    topBar={
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Text(stringResource(R.string.app_name))
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    HeroList(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}




@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SuperHeroAppPreview() {
    SuperHeroAppTheme(darkTheme=true){
        Scaffold(
            topBar={
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            stringResource(R.string.app_name),
                            style = MaterialTheme.typography.displayLarge,
                        )
                    }
                )
            }
        ) { innerPadding ->
            HeroList(modifier = Modifier.padding(innerPadding))
        }
    }
}
