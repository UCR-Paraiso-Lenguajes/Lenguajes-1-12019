/*
*Los comenlarios que comienzan con <-- son del primer capitulo y los de <!! son del segundo;
*Este programa fue creado para resolver un problema de si los parentesis estaban bien cerrados,
*en el siguiente link se encuentra el enunciado y puede probar si compila y funciona
*https://vjudge.net/contest/278572#status//F/0/
*y lo ultimo comentado abajo era como estaba antes de hacerle los cambios sugeridos por el libro.
*/
#include <iostream>
#include <string>
#include <stack>

using namespace std;

stack<char> pilaDeChars; // <-- Uso de nombres buscabres pg.22

bool seApiloParentesis = false; // <-- Uso de nombres pronunciables pg21.

string serieParentesis; // <---Uso de un nombre revelador pg18.

bool apilaParentesisCerrados(char parentesis)
{ // <!! No tiene efectos secundarios
   switch (parentesis)
   { // <!! Uso de switch statement pg38.
   case ')':
      pilaDeChars.push('(');
      return true;
   case '}':
      pilaDeChars.push('{');
      return true;
   case ']':
      pilaDeChars.push('[');
      return true;
   default:
      return false;
   }
}

void desempila()
{
   pilaDeChars.pop();
}

bool sonParentesisBalanceados(int indiceDelString)
{ // <!! Funciones con solo un parametro pg41.
   if (pilaDeChars.empty() && indiceDelString <= -1)
      return true;
   if (indiceDelString < 0)
      return false;

   seApiloParentesis = apilaParentesisCerrados(serieParentesis.at(indiceDelString));

   if (!seApiloParentesis)
   {
      if (pilaDeChars.empty() || pilaDeChars.top() != serieParentesis.at(indiceDelString))
         return false;
      desempila();
   }
   return sonParentesisBalanceados(indiceDelString - 1);
}

void vaciarPila()
{ //<!! Resuelven una cosa pg35.
   pilaDeChars = stack<char>();
}

void resolverParentesisBalancedos()
{ // <!! uso de nombres representativos pg39.
   cin >> serieParentesis;

   cout << (sonParentesisBalanceados(serieParentesis.size() - 1) ? "YES\n" : "NO\n");

   vaciarPila();
}

void resolverProblema()
{
   int numeroDeEjecuciones;
   cin >> numeroDeEjecuciones; //<-- evitar mapas mentales pg25.

   for (unsigned i = 0; i < numeroDeEjecuciones; i++)
   { // <-- uso de variables como i,j,k en ciclos pg20.
      resolverParentesisBalancedos();
   }
}

int main()
{
   resolverProblema();
   return 0;
}

/*

stack<char> pila;
bool flag = false;
string brackets;

void apile(char c){
   if(c == ')'){
      pila.push('('); return; 
   }
   if(c == '}'){
      pila.push('{'); return; 
   }
   if(c == ']'){
      pila.push('['); return; 
   }
   flag = true;
}

bool solved(int i){
   if(pila.empty() && i <= -1)return true; 
   if(i < 0) return false;
   
   apile(brackets.at(i));

   if(flag){
      if(pila.empty() || pila.top() != brackets.at(i))return false;

      pila.pop();
      flag = false;
   }
      
   return solved(i-1);
   
}


void brack(){

   
   cin >> brackets;

   cout << (solved(brackets.size()-1) ? "YES\n" : "NO\n");
   flag = false;
   while(!pila.empty())
      pila.pop();
}

int main(){
	int times;
   cin >> times;
   
   for(unsigned i = 0; i < times; i++){
      brack();
   }

	return 0;
}
*/