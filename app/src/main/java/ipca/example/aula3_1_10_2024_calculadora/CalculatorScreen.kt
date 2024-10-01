package ipca.example.aula3_1_10_2024_calculadora

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = "0")
        Row {
            Button(onClick = { /* ToDo */ } ) {
                Text(text = "7")
            }
            Button(onClick = { /* ToDo */ } ) {
                Text(text = "8")
            }
            Button(onClick = { /* ToDo */ } ) {
                Text(text = "9")
            }
        }
        Row {
            Button(onClick = { /* ToDo */ } ) {
                Text(text = "4")
            }
            Button(onClick = { /* ToDo */ } ) {
                Text(text = "5")
            }
            Button(onClick = { /* ToDo */ } ) {
                Text(text = "6")
            }
        }
        Row {
            Button(onClick = { /* ToDo */ } ) {
                Text(text = "1")
            }
            Button(onClick = { /* ToDo */ } ) {
                Text(text = "2")
            }
            Button(onClick = { /* ToDo */ } ) {
                Text(text = "3")
            }
        }
    }
}