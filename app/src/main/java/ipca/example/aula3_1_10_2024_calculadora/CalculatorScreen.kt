package ipca.example.aula3_1_10_2024_calculadora

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ipca.example.aula3_1_10_2024_calculadora.ui.theme.components.CalcButton

@Preview
@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {

    var result by remember { mutableStateOf("0") }
    var firstOperand by remember { mutableStateOf<Int?>(null) }
    var secondOperand by remember { mutableStateOf<Int?>(null) }
    var operation by remember { mutableStateOf<String?>(null) }
    var showOperator by remember { mutableStateOf(false) }

    var operand by remember { mutableStateOf(0.0) }
    var operator by remember { mutableStateOf("") }

    fun getDisplay(): Double {
        return result.toDouble()
    }

    fun setDisplay (value: Double) {

        if (value % 1 == 0.0) {
            result = value.toInt().toString()
        } else {
            result = value.toString()
        }
    }

    var userIsIntTheMiddleOfIntroduction by remember { mutableStateOf(true)}

    val onNumbPress : (String) -> Unit = { label ->
        if (userIsIntTheMiddleOfIntroduction) {
            if (result == "0") {
                if (label == ".") {
                    result = "0."
                } else {
                    result = label
                }
            } else {
                if (!result.contains(".") || label != ".") {
                    result += label
                }
            }
        } else {
            result = label
        }
        userIsIntTheMiddleOfIntroduction = true
    }

    val onOperatorPress : (String) -> Unit = { op ->
        if (operator.isNotEmpty()) {
            when(operator) {
                "+" -> operand += result.toDouble()
                "-" -> operand -= result.toDouble()
                "*" -> operand *= result.toDouble()
                "/" -> operand /= result.toDouble()
                "=" -> operator = ""
            }
            setDisplay(operand)
        }
        operand = getDisplay()
        operator = op

        userIsIntTheMiddleOfIntroduction = false
    }

    Column(
        modifier = modifier
        .padding(16.dp)
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            textAlign = TextAlign.Right,
            text = if (showOperator && operation != null) {
                "${firstOperand ?: ""} $operation ${secondOperand ?: ""}"
            } else {
                result
            },
            style = MaterialTheme.typography.bodyLarge
        )
        Row(
            modifier = Modifier
                .weight(1f),
        ) {
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "C",
                onClick = { /* ToDo */ }
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "()",
                onClick = { /* ToDo */ }
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "%",
                onClick = { /* ToDo */ }
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "/",
                isOperation = true,
                onClick = onOperatorPress
            )
        }
        Row(
            modifier = Modifier
                .weight(1f),
        ) {
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "7",
                onClick = onNumbPress
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "8",
                onClick = onNumbPress
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "9",
                onClick = onNumbPress
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "*",
                isOperation = true,
                onClick = onOperatorPress
            )
        }
        Row(
            modifier = Modifier
                .weight(1f),
        ) {
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "4",
                onClick = onNumbPress
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "5",
                onClick = onNumbPress
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "6",
                onClick = onNumbPress
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "-",
                isOperation = true,
                onClick = onOperatorPress
            )
        }
        Row(
            modifier = Modifier
                .weight(1f),
        ) {
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "1",
                onClick = onNumbPress
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "2",
                onClick = onNumbPress
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "3",
                onClick = onNumbPress
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "+",
                isOperation = true,
                onClick = onOperatorPress
            )
        }
        Row(
            modifier = Modifier
                .weight(1f),
        ) {
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "+/-",
                onClick = { /* ToDo */ }
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "0",
                onClick = onNumbPress
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = ".",
                onClick = onNumbPress
            )
            CalcButton(
                modifier = Modifier.weight(1f),
                label = "=",
                isOperation = true,
                onClick = onOperatorPress
            )
        }
    }
}