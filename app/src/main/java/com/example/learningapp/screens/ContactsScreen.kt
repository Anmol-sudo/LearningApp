package com.example.learningapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learningapp.Contacts
import com.example.learningapp.R

val contactList: List<Contacts> = listOf(
    Contacts(R.drawable.contact_image_1, R.string.contact_john_doe_name, R.string.contact_john_doe_number),
    Contacts(R.drawable.contact_image_2, R.string.contact_jane_smith_name, R.string.contact_jane_smith_number),
    Contacts(R.drawable.contact_image_3, R.string.contact_peter_jones_name, R.string.contact_peter_jones_number),
    Contacts(R.drawable.contact_image_4, R.string.contact_mary_brown_name, R.string.contact_mary_brown_number),
    Contacts(R.drawable.contact_image_5, R.string.contact_david_williams_name, R.string.contact_david_williams_number),
    Contacts(R.drawable.contact_image_6, R.string.contact_linda_garcia_name, R.string.contact_linda_garcia_number),
    Contacts(R.drawable.contact_image_7, R.string.contact_michael_rodriguez_name, R.string.contact_michael_rodriguez_number),
    Contacts(R.drawable.contact_image_8, R.string.contact_patricia_martinez_name, R.string.contact_patricia_martinez_number),
    Contacts(R.drawable.contact_image_9, R.string.contact_christopher_hernandez_name, R.string.contact_christopher_hernandez_number),
    Contacts(R.drawable.contact_image_10, R.string.contact_elizabeth_lopez_name, R.string.contact_elizabeth_lopez_number)
)

@Composable
fun ContactsScreen(contacts: List<Contacts> = contactList) {

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(8.dp)
    ) {
        Text(
            "Horizontal Scroll Screen",
            modifier = Modifier.align(Alignment.Start),
            style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow (
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            horizontalArrangement  = Arrangement.spacedBy(8.dp),
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) { items(contactList) { contact ->
            ContactCard(contact = contact)
            }
        }
    }
}

@Composable
fun ContactCard(contact: Contacts) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .width(180.dp)
            .wrapContentHeight()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Image(
                painter = painterResource(id = contact.image),
                contentDescription = stringResource(id = contact.titleResId),
                modifier = Modifier
                    .size(160.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .padding(bottom = 8.dp)
                    .align(Alignment.CenterHorizontally),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(id = contact.titleResId),
                modifier = Modifier
                    .padding(bottom = 8.dp),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = stringResource(id = contact.numberResId),
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    ContactsScreen()
}