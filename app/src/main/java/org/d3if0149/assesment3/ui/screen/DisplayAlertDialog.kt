package org.d3if0149.assesment3.ui.screen

import android.content.res.Configuration
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import org.d3if0149.assesment3.R
import org.d3if0149.assesment3.ui.theme.Assesment3Theme

@Composable
fun DisplayAlertDialog(
    openDialog: Boolean,
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit
) {
    if (openDialog){
        AlertDialog(
            text = { Text(text = stringResource(R.string.HapusData))},
            confirmButton = {
                TextButton(onClick = { onConfirmation() }) {
                    Text(text = stringResource(R.string.hapus2))
                }
            },
            dismissButton = {
                TextButton(onClick = {onDismissRequest()}) {
                    Text(text = stringResource(R.string.batal))
                }
            },
            onDismissRequest = {onDismissRequest()}
        )
    }
}

@Preview(showBackground = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun DisplayAlertDialogPreview() {
    Assesment3Theme{
        DisplayAlertDialog(
            openDialog = true,
            onDismissRequest = {},
            onConfirmation = {}
        )
    }
}