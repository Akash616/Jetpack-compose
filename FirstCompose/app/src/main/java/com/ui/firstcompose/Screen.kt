package com.ui.firstcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(heightDp = 500)
@Composable
fun PreviewItem() {
    //Like listView
    /*Column(
        modifier = Modifier
        .verticalScroll(state = rememberScrollState()) //scrolling
    ) {
        getCategoryList().map { item ->
            BlogCategory(img = item.img, title = item.title, subtitle = item.subtitle)
        }
    }*/

    //Like Recyclerview
    LazyColumn(content = {
        items(getCategoryList()) { item ->
            BlogCategory(img = item.img, title = item.title, subtitle = item.subtitle)
        }
    })
}

@Composable  //Parameterized composable
fun BlogCategory(img: Int, title: String, subtitle: String){
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(img),
                contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f) //Row ka 20%
            )
            ItemDescription(title, subtitle,
                Modifier
                    .padding(end = 8.dp)
                    .weight(.8f) //Row ka 80%
            )
        }
    }
}

@Composable
private fun ItemDescription(title: String, subtitle: String, modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Thin
        )
    }
}

data class Category(val img: Int, val title: String, val subtitle: String)

fun getCategoryList() : MutableList<Category>{
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.ic_add_reaction,"Programming","Learn Programming. Lang"))
    list.add(Category(R.drawable.ic_airplanemode,"Technology","Learn Technology. Lang"))
    list.add(Category(R.drawable.ic_android,"Android","Learn Android. Lang"))
    list.add(Category(R.drawable.ic_launcher_background,"Graphics","Learn Graphics. Lang"))
    list.add(Category(R.drawable.ic_add_reaction,"Programming","Learn Programming. Lang"))
    list.add(Category(R.drawable.ic_airplanemode,"Technology","Learn Technology. Lang"))
    list.add(Category(R.drawable.ic_android,"Android","Learn Android. Lang"))
    list.add(Category(R.drawable.ic_launcher_background,"Graphics","Learn Graphics. Lang"))
    list.add(Category(R.drawable.ic_add_reaction,"Programming","Learn Programming. Lang"))
    list.add(Category(R.drawable.ic_airplanemode,"Technology","Learn Technology. Lang"))
    list.add(Category(R.drawable.ic_android,"Android","Learn Android. Lang"))
    list.add(Category(R.drawable.ic_launcher_background,"Graphics","Learn Graphics. Lang"))
    list.add(Category(R.drawable.ic_add_reaction,"Programming","Learn Programming. Lang"))
    list.add(Category(R.drawable.ic_airplanemode,"Technology","Learn Technology. Lang"))
    list.add(Category(R.drawable.ic_android,"Android","Learn Android. Lang"))
    list.add(Category(R.drawable.ic_launcher_background,"Graphics","Learn Graphics. Lang"))
    return list
}