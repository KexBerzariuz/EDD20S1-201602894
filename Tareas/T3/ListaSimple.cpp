#include <iostream>
using namespace std;


struct nodo{
  int Carne;
string nombre;

struct nodo * siguiente;
};

struct nodo *creanodo(void) {
 
  //return (struct nodo *) malloc(sizeof(struct nodo));
} 
typedef struct nodo *Tlista;

void Insertar(Tlista &list, string nombre, int Carne){
 Tlista r;
    r = new(struct nodo);
 r->nombre = nombre;
 r->Carne = Carne;
 list = r;

}

Tlista Buscar(Tlista &list, int Carne){
  Tlista r = list;
while(r!=NULL){
  if(r ->Carne ==Carne){
    cout << "valor encontrado"<< endl;
    return r;

  }
  r = r->siguiente;
}
}

void Eliminar(Tlista &list, int Carne){
  Tlista p , anterior;
  p = list;
  if (list !=NULL)
  {
    while(p!=NULL){
      if(p->Carne = Carne){
        if(p==list){
          p->siguiente= NULL;
        }else{
          anterior->siguiente = p->siguiente;
        }
      } 
      anterior = p;
     p= p ->siguiente ;

    
    }


  }
  
}
    int main(){
        Tlista lista = NULL;
        string Nombre;
        int Carnet,opcion;
        //Datos dataas("Hola", 2);
        cout<< " Menu de Opciones \n" <<endl ;
        cout<< "1 Añadir datos \n" <<endl ;
        cout<< "2 Eliminar Datos \n" <<endl;
        cout<< "3 buscar datos \n"<< endl;
         cout<< " opcion a insertar: "; cin>> opcion;
        switch (opcion)
        {
        case 1:
            cout<< " Ingresar numero de carnet \n" <<endl ;
            cout<< ""; cin>> Carnet;
 cout<< "\n Ingresar el nombre " <<endl ;
            cout<< ""; cin>> Nombre;
            Insertar(lista, Nombre,Carnet);
          break;
        case 2:
         cout<< " Ingresar numero de carnet \n" <<endl ;
            cout<< ""; cin>> Carnet;
            Eliminar(lista, Carnet);
        break;
        case 3: 
 cout<< " Ingresar numero de carnet \n" <<endl ;
            cout<< ""; cin>> Carnet;
            Buscar(lista, Carnet);
        break;
        default:
          break;
        }
 
}
