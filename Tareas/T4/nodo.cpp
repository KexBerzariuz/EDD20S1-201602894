#include <iostream>

class nodo{
  private:
    char caracter;
    nodo *Anterior;
    nodo *Siguiente;
    friend class Listadoble;
};

class Listadoble{
  public:
    Listadoble();
    void Agregar(char a);
    void EliminarUltimo();
    nodo *Buscar(char* a);
private:
    nodo *Cola;
    nodo *Raiz;

};

Listadoble::Listadoble(){

        Raiz = new nodo();
        Cola = new nodo();
        Raiz->Anterior =NULL;
        Raiz->Siguiente= Cola;
        Cola ->Siguiente = NULL;
        Cola ->Anterior = Raiz;


}

void Listadoble::Agregar(char caracter){
    nodo *nd = new nodo();
    nd->caracter = caracter;
    nd->Siguiente = Raiz->Siguiente;
    nd->Anterior = Raiz;

    Raiz->Siguiente = nd;
    Raiz->Siguiente->Anterior = nd;

}

void Listadoble::EliminarUltimo(){
    if(Cola->Anterior != Raiz){
        nodo *nd = Cola->Anterior->Anterior;

        Cola->Anterior = nd;
        nd->Siguiente =Cola;

    }else{
       printf("no existe ningun dato en la lista");
    }

}

nodo *Listadoble::Buscar(char *a){
    nodo *nd = Raiz->Siguiente;
    while(nd!= Cola){
        if(nd->caracter == a[0]){
            return nd;
        }
        nd = nd->Siguiente;

    }

}
