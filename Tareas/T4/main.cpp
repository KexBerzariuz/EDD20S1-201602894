#include <iostream>
#include "nodo.cpp"
int main()
{
    int desicion;
    printf("Ingrese una de las siguientes opciones");
    printf( "\n 1 Ingresar a la lista ");
    printf("\n  2 Eliminar de la lista");
    printf("\n  3 Buscar en la lista");
    scanf("%d", desicion);

    switch (desicion) {
    case 1:
        char cara;
        printf("Ingresar caracter que desea agregar a la lista");
        scanf("%c", cara);
        Listadoble ld ;
        ld.Agregar(cara);

        break;
     case 2:
        ld.EliminarUltimo();
        break;
     case 3:
        char* caracteres;
        printf("palabra que desea buscar:");
        scanf("100%", caracteres);
        ld.Buscar(caracteres);
        break;
    default:
        break;
    }
}
