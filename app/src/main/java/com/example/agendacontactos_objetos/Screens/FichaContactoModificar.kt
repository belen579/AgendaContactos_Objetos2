package com.example.agendacontactos_objetos.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Save
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.agendacontactos_objetos.Data.Contacto
import com.example.agendacontactos_objetos.Data.viewModelContacto
import com.example.agendacontactos_objetos.R
import com.example.agendacontactos_objetos.navigation.Screens


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun fichacontactomodificar(viewModelContacto: viewModelContacto, navController: NavController, contacto:Contacto) {

    var nombre by remember {
        mutableStateOf(contacto.nombre)
    }
    var email by remember {
        mutableStateOf(contacto.email)
    }
    var telefono by remember {
        mutableStateOf(contacto.telefono)
    }

    var context = LocalContext.current


    LaunchedEffect(contacto) {
        nombre = contacto.nombre
        email = contacto.email
        telefono = contacto.telefono



        println(contacto.nombre)
    }



    Scaffold(

        topBar = {
            TopAppBar(
                title = { Text("Contacto") },
                actions={
                    IconButton(  onClick = {

                        val  contacto = Contacto(
                            nombre,
                            telefono,
                            email,
                            R.drawable.neutra,
                            viewModelContacto.nextid
                        )
                        viewModelContacto.guardarcontactoarchivo(
                            contacto)



                        navController.navigate(route = Screens.inicio.route)
                    }) {
                        Icon(Icons.Default.Save, contentDescription = "Guardar",modifier = Modifier.size(32.dp))
                    }
                }


            )

        }
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .padding(top = 50.dp), horizontalAlignment =  Alignment.CenterHorizontally,
        ) {

            Image(
                painter = painterResource(id = R.drawable.neutra),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Icon(Icons.Default.AccountCircle, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Icon(Icons.Default.Call, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                OutlinedTextField(
                    value = telefono,
                    onValueChange = { telefono = it },
                    label = { Text("Telefono") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))


            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Icon(Icons.Default.Email, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = {  email= it },
                    label = { Text("Email") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

//

        }

    }




}
