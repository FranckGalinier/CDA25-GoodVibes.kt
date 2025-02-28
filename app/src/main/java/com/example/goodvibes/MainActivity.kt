package com.example.goodvibes

import TextScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.tooling.preview.Preview
import com.example.goodvibes.composant.AffirmationCard
import com.example.goodvibes.composant.AffirmationList
import com.example.goodvibes.data.Datasource
import com.example.goodvibes.model.Affirmation
import com.example.goodvibes.ui.theme.GoodvibesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GoodvibesTheme {
                HomeApp()
            }
        }
    }
}

@Composable
fun HomeApp(){
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        AffirmationApp(Modifier.padding(innerPadding))
    }
}

@Composable
fun AffirmationApp( modifier: Modifier = Modifier){
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start =  WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateEndPadding(layoutDirection)
            )

    ) {
        AffirmationList(
            affirmationList = Datasource().loadAffirmation()
        )
    }
}
@Composable
fun AutreText(){
    Text("Je suis un composant de textetetete")
}

@Preview
@Composable
fun CardPreview(){
    GoodvibesTheme {
        AffirmationApp()
    }
}

@Preview
@Composable
fun AutreTextPreview(){
    GoodvibesTheme {
        AutreText()
    }
}
@Preview
@Composable
fun GlobalPreview(){
    GoodvibesTheme {
        HomeApp()
    }
}


