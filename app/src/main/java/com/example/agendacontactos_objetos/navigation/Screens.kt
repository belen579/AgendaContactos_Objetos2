package com.example.agendacontactos_objetos.navigation

sealed class Screens(val route:String){

    object inicio: Screens("MainActivity")
    object ficha : Screens ("FichaContacto")
    object fichamodificar : Screens ("FichaContactoModificar")

}
